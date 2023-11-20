package com.example.bank_audit.service;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import java.lang.reflect.Field;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.bank_audit.entity.Bank;
import com.example.bank_audit.entity.Branch;
import com.example.bank_audit.entity.LoanDetail;
import com.example.bank_audit.entity.Year;
import com.example.bank_audit.repo.LoanDetailRepo;

@Service
public class ExcelService {

	@Autowired
	private StatutoryAuditService statutoryAuditService;
	@Autowired
	private LoanDetailRepo loanDetailRepo;
	public void saveDataToTables(MultipartFile fileUpload, Class<?>... entityClasses) throws IOException {
        try (InputStream inputStream = fileUpload.getInputStream()) {
            Workbook workbook = new XSSFWorkbook(inputStream);

            for (Class<?> entityClass : entityClasses) {
                processSheet(workbook, entityClass);
            }

            // Close the workbook to release resources
            workbook.close();
        }
    }

	private void processSheet(Workbook workbook, Class<?> entityClass) {
	    Sheet sheet = workbook.getSheet("Statutory Audit");
	    if (sheet == null) {
	        return; // Sheet not found for the entity
	    }

	    Iterator<Row> rowIterator = sheet.iterator();
	    // Skip the first four rows
//	    for (int i = 0; i < 2 && rowIterator.hasNext(); i++) {
//	        rowIterator.next();
//	    }

	    Row headerRow = rowIterator.next(); // Get the header row

	    List<Object> entities = new ArrayList<>();
	    while (rowIterator.hasNext()) {
	        Row row = rowIterator.next();
	        Object entity = createEntityFromRow(row, entityClass, headerRow);
	        entities.add(entity);
	    }

	    // Save entities to the database (You need to implement the appropriate service for each entity)
	    saveEntitiesToDatabase(entities, entityClass);
	}
	
	private int findHeaderCellNum(Row headerRow, String fieldName) {
	    int headerCellNum = 1; // Start from the second column (index 1)
	    for (Cell headerCell : headerRow) {
	        String headerCellValue = getCellValueAsString(headerCell);
	        if (headerCellValue != null && headerCellValue.equals(fieldName)) {
	            break;
	        }
	        headerCellNum++;
	    }
	    return headerCellNum;
	}
	private String getCellValueAsString(Cell cell) {
	    if (cell == null) {
	        return null;
	    }

	    switch (cell.getCellType()) {
	        case STRING:
	            return cell.getStringCellValue();
	        case NUMERIC:
	            // Handle numeric values
	            if (DateUtil.isCellDateFormatted(cell)) {
	                // Handle date values if needed
	                return cell.getDateCellValue().toString();
	            } else {
	                return String.valueOf(cell.getNumericCellValue());
	            }
	        case BOOLEAN:
	            return String.valueOf(cell.getBooleanCellValue());
	        case FORMULA:
	            try {
	                // Attempt to evaluate the formula cell
	                return String.valueOf(cell.getNumericCellValue());
	            } catch (Exception e) {
	                // Handle the error in case the formula evaluation fails
	                return null;
	            }
	        case BLANK:
	            return null; // Handle blank cells
	        default:
	            return null;
	    }
	}


    private Object createEntityFromRow(Row row, Class<?> entityClass, Row headerRow) {
    	 Field[] fields = entityClass.getDeclaredFields();
    	    try {
    	        Object entity = entityClass.getDeclaredConstructor().newInstance();
    	        int cellNum = 0; // Start from the second column (index 1)
    	        for (Field field : fields) {
    	            field.setAccessible(true);
    	            Cell cell = row.getCell(cellNum++);
    	            String fieldName = field.getName();
    	            int headerCellNum = findHeaderCellNum(headerRow, fieldName);

    	            // Get the cell value based on the field type
    	            Object cellValue = getCellValue(cell, field.getType());


                // Handle null values
                if (cellValue == null) {
                    // Perform appropriate action for null values, for example, set a default value
                    // or throw an exception depending on your business logic
                    // For now, I'm setting default values for certain types, but adjust based on your needs

                    if (field.getType() == boolean.class || field.getType() == Boolean.class) {
                        field.set(entity, false); // Default value for boolean
                    } else if (field.getType() == int.class || field.getType() == Integer.class) {
                        field.set(entity, 0); // Default value for int
                    } else if (field.getType() == long.class || field.getType() == Long.class) {
                        field.set(entity, 0L); // Default value for long
                    } else if (field.getType() == double.class || field.getType() == Double.class) {
                        field.set(entity, 0.0); // Default value for double
                    } else {
                        // Handle other types as needed
                        field.set(entity, null);
                    }
                } else {
                    // Set the value to the field
                    if (field.getType() == boolean.class || field.getType() == Boolean.class) {
                        if (cellValue instanceof Boolean) {
                            field.set(entity, cellValue);
                        } else if (cellValue instanceof String) {
                            // Convert String to boolean if needed
                            field.set(entity, Boolean.parseBoolean((String) cellValue));
                        } else if (cellValue instanceof Number) {
                            // Convert numeric values to boolean (0 as false, non-zero as true)
                            field.set(entity, ((Number) cellValue).intValue() != 0);
                        } else {
                            // Handle other cases or throw an exception if necessary
                            throw new IllegalArgumentException("Cannot set boolean field with a non-boolean value");
                        }
//                    } else if (field.getType() == int.class || field.getType() == Integer.class) {
//                        // Handle int type
//                        if (cellValue instanceof Number) {
//                            field.set(entity, ((Number) cellValue).intValue());
//                        } else if (cellValue instanceof String) {
//                            // Convert String to int if needed
//                            field.set(entity, Integer.parseInt((String) cellValue));
//                        }
                    } else if (field.getType() == double.class || field.getType() == Double.class) {
                        // Handle double type
                        if (cellValue instanceof Number) {
                            field.set(entity, ((Number) cellValue).doubleValue());
                        } else if (cellValue instanceof String) {
                            // Convert String to double if needed
                            field.set(entity, Double.parseDouble((String) cellValue));
                        }
                    } else {
                        // Handle other types
                        field.set(entity, cellValue);
                    }
                }
            }
            return entity;
        } catch (Exception e) {
            e.printStackTrace(); // Handle this exception according to your needs
            return null;
        }
    }




    private Object getCellValue(Cell cell, Class<?> fieldType) {
        if (cell == null) {
            return null;
        }

        switch (cell.getCellType()) {
            case STRING:
            	String stringValue = cell.getStringCellValue().trim().toLowerCase();
                if (fieldType == Boolean.class || fieldType == boolean.class) {
                    // Convert string to boolean based on "Yes" or "No"
                    return stringValue.equals("yes");
                } else {
                    return stringValue;
                }
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    // Handle date values if needed
                    return cell.getDateCellValue();
                } else {
                    // Handle numeric values based on field type
                    if (fieldType == String.class) {
                        // Convert numeric value to string
                        return String.valueOf(cell.getNumericCellValue());
                    } else if (fieldType == Integer.class || fieldType == int.class) {
                        return (cell.getCellType() == CellType.NUMERIC) ? (int) cell.getNumericCellValue() : null;
                    } else if (fieldType == Long.class || fieldType == long.class) {
                        return (cell.getCellType() == CellType.NUMERIC) ? (long) cell.getNumericCellValue() : null;
                    } else if (fieldType == Double.class || fieldType == double.class) {
                        return (cell.getCellType() == CellType.NUMERIC) ? cell.getNumericCellValue() : null;
                    } else {
                        // Handle other numeric types as needed
                        return null;
                    }

                }
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case FORMULA:
                try {
                    // Attempt to evaluate the formula cell
                    return cell.getNumericCellValue();
                } catch (Exception e) {
                    // Handle the error in case the formula evaluation fails
                    return null;
                }
            case BLANK:
                return null; // Handle blank cells
            default:
                return null;
        }
    }

    private void saveEntitiesToDatabase(List<Object> entities, Class<?> entityClass) {
    	 if (entityClass.equals(LoanDetail.class)) {
    	        List<?> castedEntities = entities;
    	        List<LoanDetail> loanDetail = (List<LoanDetail>) castedEntities;
    	        loanDetailRepo.saveAll(loanDetail);
    	 }
    	 else if (entityClass.equals(Branch.class)) {
 	        List<?> castedEntities = entities;
 	        List<Branch> branches = (List<Branch>) castedEntities;
 	       statutoryAuditService.saveOrUpdateIfExists1(branches);
 	 }
//    	 else if (entityClass.equals(Year.class)) {
//             List<Year> years = (List<Year>) entities;
//             yearService.saveAllYears(years);
//         } else if (entityClass.equals(Bank.class)) {
//             List<Bank> banks = (List<Bank>) entities;
//             bankService.saveAllBanks(banks);
//         }
	
    }
	
}
