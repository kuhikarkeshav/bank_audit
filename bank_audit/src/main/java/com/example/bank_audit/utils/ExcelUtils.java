//package com.example.bank_audit.utils;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//
//public class ExcelUtils {
//
//	public static List<Row> getSheetDataRows(Sheet sheet){
//        Iterator<Row> rowIterator = sheet.rowIterator();
//        List<Row> rows = new ArrayList<>();
//        for (int i = 0; i < 3 && rowIterator.hasNext(); i++) {
//            rowIterator.next();
//        }
//        rowIterator.next(); // skip first row (column headers)
//        while (rowIterator.hasNext()){
//            Row currentRow = rowIterator.next();
//            // TODO: check why not always works
//            if (checkNextRowNotEmptyOrBlank(currentRow)) rows.add(currentRow);
//        }
//        return rows;
//    }
//	  public static boolean checkNextRowNotEmptyOrBlank(Row row) {
//	        Cell firstCell = row.getCell(0);
//	        if (firstCell == null) return false;
//	        CellType cellType = firstCell.getCellType();
//	        return switch (cellType) {
//	            case BLANK, _NONE, ERROR -> false;
//	            case STRING -> !firstCell.getStringCellValue().isBlank()
//	                    && !firstCell.getStringCellValue().trim().isEmpty()
//	                    && !firstCell.getStringCellValue().isEmpty();
//	            case BOOLEAN, FORMULA, NUMERIC -> true;
//	        };
//	    }
//
//}
