//package com.example.bank_audit.enums;
//
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.List;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.Row;
//
//import com.example.bank_audit.dto.ExcelRowDto;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//
//
//@Getter
//@AllArgsConstructor
//public enum ColumnConfig {
//
//	NAME_OF_BRANCH__Statutory_Audit(1, true, BulkModule.Statutory_Audit, CellValueDataType.ALPHANUMERIC,
//            "NAME OF BRANCH", DependencyValidation.NONE, CellValueFormat.NONE) {
//        @Override public ExcelRowDto mapRowValue(ExcelRowDto excelRowDto, Row row) {
//            return ExcelRowDto.identifyAssetType(excelRowDto)
//                    .setName(row.getCell(columnIndex).getStringCellValue());
//        }
//    },
//	TAHSIL__Statutory_Audit(2, true, BulkModule.Statutory_Audit, CellValueDataType.ALPHANUMERIC,
//            "Tahasil", DependencyValidation.NONE, CellValueFormat.NONE) {
//        @Override public ExcelRowDto mapRowValue(ExcelRowDto excelRowDto, Row row) {
//            return ExcelRowDto.identifyAssetType(excelRowDto)
//                    .setTahsil(row.getCell(columnIndex).getStringCellValue());
//        }
//    },
//	PACS_ATTACH__Statutory_Audit(13, true, BulkModule.Statutory_Audit, CellValueDataType.ALPHANUMERIC,
//	        "WHETHER PACS ARE ATTACHED WITH THE BRANCH", DependencyValidation.NONE, CellValueFormat.NONE) {
//	    @Override
//	    public ExcelRowDto mapRowValue(ExcelRowDto excelRowDto, Row row) {
//	        Cell cell = row.getCell(columnIndex);
//	        String cellValue = (cell.getCellType() == CellType.STRING) ? cell.getStringCellValue().trim().toLowerCase() : null;
//
//	        boolean isPacsAttached;
//	        if ("yes".equalsIgnoreCase(cellValue)) {
//	            isPacsAttached = true;
//	       
//	        } else {
//	            
//	            isPacsAttached = false;
//	        }
//
//	        return ExcelRowDto.identifyAssetType(excelRowDto)
//	                .setPacsAttach(isPacsAttached);
//	    }
//	},
////	NO_OF_PACS__Statutory_Audit(14, true, BulkModule.Statutory_Audit, CellValueDataType.NUMERIC,
////            "NUMBER OF PACS ATTACHED WITH THE BRANCH", DependencyValidation.NONE, CellValueFormat.NONE) {
////        @Override public ExcelRowDto mapRowValue(ExcelRowDto excelRowDto, Row row) {
////            return ExcelRowDto.identifyAssetType(excelRowDto)
////                    .setNoOfPacs((int) row.getCell(columnIndex).getNumericCellValue());
////        }
////    },
//	ATM_ATTACH__Statutory_Audit(15, true, BulkModule.Statutory_Audit, CellValueDataType.ALPHANUMERIC,
//	        "WHETHER ATM IS ATTACHED TO THE BRANCH", DependencyValidation.NONE, CellValueFormat.NONE) {
//	    @Override
//	    public ExcelRowDto mapRowValue(ExcelRowDto excelRowDto, Row row) {
//	        Cell cell = row.getCell(columnIndex);
//	        String cellValue = (cell.getCellType() == CellType.STRING) ? cell.getStringCellValue().trim().toLowerCase() : null;
//
//	        boolean isAtmAttached;
//	        if ("yes".equalsIgnoreCase(cellValue)) {
//	            isAtmAttached = true;
//	        
//	        } else {
//	            isAtmAttached = false;
//	        }
//
//	        return ExcelRowDto.identifyAssetType(excelRowDto)
//	                .setAtmAttach(isAtmAttached);
//	    }
//	},
//	LOCKER_FACILITY__Statutory_Audit(16, true, BulkModule.Statutory_Audit, CellValueDataType.ALPHANUMERIC,
//	        "WHETHER LOCKER FACILITY IS AVAILABLE AT THE BRANCH", DependencyValidation.NONE, CellValueFormat.NONE) {
//	    @Override
//	    public ExcelRowDto mapRowValue(ExcelRowDto excelRowDto, Row row) {
//	        Cell cell = row.getCell(columnIndex);
//	        String cellValue = (cell.getCellType() == CellType.STRING) ? cell.getStringCellValue().trim().toLowerCase() : null;
//
//	        boolean hasLockerFacility;
//	        if ("yes".equalsIgnoreCase(cellValue)) {
//	            hasLockerFacility = true;
//	        } else {
//	            hasLockerFacility = false;
//	        }
//
//	        return ExcelRowDto.identifyAssetType(excelRowDto)
//	                .setLockerFacility(hasLockerFacility);
//	    }
//	},
//	GOLD_LOAN_FACILITY__Statutory_Audit(17, true, BulkModule.Statutory_Audit, CellValueDataType.ALPHANUMERIC,
//	        "WHETHER GOLD LOAN FACILITY IS AVAILABLE AT THE BRANCH", DependencyValidation.NONE, CellValueFormat.NONE) {
//	    @Override
//	    public ExcelRowDto mapRowValue(ExcelRowDto excelRowDto, Row row) {
//	        Cell cell = row.getCell(columnIndex);
//	        String cellValue = (cell.getCellType() == CellType.STRING) ? cell.getStringCellValue().trim().toLowerCase() : null;
//
//	        boolean hasGoldLoanFacility;
//	        if ("yes".equalsIgnoreCase(cellValue)) {
//	            hasGoldLoanFacility = true;
//	        } else {
//	            hasGoldLoanFacility = false;
//	        }
//
//	        return ExcelRowDto.identifyAssetType(excelRowDto)
//	                .setGoldLoanFacility(hasGoldLoanFacility);
//	    }
//	},
////	HAS_ACCOUNT_WITH_SBI_BEFORE_NOV2021__Statutory_Audit(18, true, BulkModule.Statutory_Audit, CellValueDataType.ALPHANUMERIC,
////            "WHETHER BRANCH IS HAVING ACCOUNT WITH OTHER BANK (SBI) UP TO 30.11.2021", DependencyValidation.NONE, CellValueFormat.NONE) {
////        @Override public ExcelRowDto mapRowValue(ExcelRowDto excelRowDto, Row row) {
////            return ExcelRowDto.identifyAssetType(excelRowDto)
////                    .setHasAccountWithSBIBeforeNov2021((int) row.getCell(columnIndex).getNumericCellValue());
////        }
////    },
////	HAS_ACCOUNT_WITH_SBI_AFTER_NOV202__Statutory_Audit(19, true, BulkModule.Statutory_Audit, CellValueDataType.ALPHANUMERIC,
////            "WHETHER BRANCH IS HAVING ACCOUNT WITH OTHER BANK (SBI) SINCE 01.12.2021", DependencyValidation.NONE, CellValueFormat.NONE) {
////        @Override public ExcelRowDto mapRowValue(ExcelRowDto excelRowDto, Row row) {
////            return ExcelRowDto.identifyAssetType(excelRowDto)
////                    .setHasAccountWithSBIAfterDec2021((int) row.getCell(columnIndex).getNumericCellValue());
////        }
////    },
//	CASH_RETENSION_LIMIT_BEFORE_MAY20222__Statutory_Audit(20, true, BulkModule.Statutory_Audit, CellValueDataType.ALPHANUMERIC,
//            "CASH RETENTION LIMIT OF THE BRANCH UP TO 31.05.2022", DependencyValidation.NONE, CellValueFormat.NONE) {
//        @Override public ExcelRowDto mapRowValue(ExcelRowDto excelRowDto, Row row) {
//            return ExcelRowDto.identifyAssetType(excelRowDto)
//                    .setCashRetentionLimitBeforeMay2022((int) row.getCell(columnIndex).getNumericCellValue());
//        }
//    },
//	CASH_RETENSION_LIMIT_AFTER_JUNE20222__Statutory_Audit(21, true, BulkModule.Statutory_Audit, CellValueDataType.ALPHANUMERIC,
//            "CASH RETENTION LIMIT OF THE BRANCH SINCE 01.06.2022", DependencyValidation.NONE, CellValueFormat.NONE) {
//        @Override public ExcelRowDto mapRowValue(ExcelRowDto excelRowDto, Row row) {
//            return ExcelRowDto.identifyAssetType(excelRowDto)
//                    .setCashRetentionLimitAfterJun2022((int) row.getCell(columnIndex).getNumericCellValue());
//        }
//    };
////	;
////	DATE__Statutory_Audit(2, true, BulkModule.Statutory_Audit, CellValueDataType.ALPHANUMERIC,
////            "DATE OF  INTERNAL AUDIT", DependencyValidation.NONE, CellValueFormat.NONE) {
////        @Override public ExcelRowDto mapRowValue(ExcelRowDto excelRowDto, Row row) {
////            return ExcelRowDto.identifyAssetType(excelRowDto)
////                    .setDate(row.getCell(columnIndex).getDateCellValue());
////        }
////    },
////	ATTENDED_BY__Statutory_Audit(2, true, BulkModule.Statutory_Audit, CellValueDataType.ALPHANUMERIC,
////            "ATTENDED BY", DependencyValidation.NONE, CellValueFormat.NONE) {
////        @Override public ExcelRowDto mapRowValue(ExcelRowDto excelRowDto, Row row) {
////            return ExcelRowDto.identifyAssetType(excelRowDto)
////                    .setAttended_by(row.getCell(columnIndex).getStringCellValue());
////        }
////    };
//	
//	  /**
//     * index of column in sheet
//     */
//    final int columnIndex;
//    /**
//     * validates if value existence is mandatory
//     */
//    final boolean mandatory;
//    /**
//     * Corresponding to sheet BulkModule
//     */
//    final BulkModule bulkModule;
//    /**
//     * determines cell validation strategy
//     */
//    final CellValueDataType cellDataType;
//    /**
//     * required column name in Sheet
//     */
//    final String columnName;
//    /**
//     * determines related/dependent database records validation strategy
//     */
//    final DependencyValidation dependencyValidation;
//    /**
//     * determines format validation strategy
//     */
//    final CellValueFormat format;
//
//    /**
//     * Implementation of cell value mapping strategy
//     *
//     * @param excelRowDto required dto class
//     * @param row mapped {@link Row}
//     * @return dto class with mapped fields
//     */
//    public abstract ExcelRowDto mapRowValue(ExcelRowDto excelRowDto, Row row);
//
//    /**
//     * Get list of columns.
//     *
//     * @param excelModule search param for columns
//     * @return list of {@link ColumnConfig} belonging to selected module
//     */
//  
//	
//	
//	 public static List<ColumnConfig> getListByModule(BulkModule excelModule){
//	        return Arrays.stream(values())
//	                .filter(col -> col.getBulkModule().equals(excelModule))
//	                .sorted(Comparator.comparingInt(ColumnConfig::getColumnIndex))
//	                .toList();
//	    }
//}
