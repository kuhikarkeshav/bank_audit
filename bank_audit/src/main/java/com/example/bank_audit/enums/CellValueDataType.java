//package com.example.bank_audit.enums;
//
//import java.util.Date;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//
//@Getter
//@AllArgsConstructor
//public enum CellValueDataType {
//    NUMERIC {
//        @Override
//        public boolean isCellValid(Cell cell) {
//            return cell.getCellType() == CellType.NUMERIC;
//        }
//    }
//    ,ALPHANUMERIC { //TODO: Any validation required?
//        @Override
//        public boolean isCellValid(Cell cell){
//            CellType cellType = cell.getCellType();
//            return switch (cellType) {
////                case STRING -> Pattern.matches(ExcelConstants.REGEX_ALPHANUMERIC_WITH_SPACES, cell.getStringCellValue());
//                case STRING -> true;
//                case NUMERIC -> true;
//                default -> false;
//            };
//        }
//    }
//
//    ,BOOLEAN {
//            @Override
//            public boolean isCellValid(Cell cell){
//                CellType cellType = cell.getCellType();
//                return switch (cellType) {
//                    case BOOLEAN -> true;
//                    case STRING -> cell.getStringCellValue().trim().equalsIgnoreCase("false")
//                                || cell.getStringCellValue().trim().equalsIgnoreCase("true")
//                    || cell.getStringCellValue().trim().equalsIgnoreCase("yes")
//                    || cell.getStringCellValue().trim().equalsIgnoreCase("--");
//                    default -> false;
//                };
//            }
//        }
//     
////    ,FLOAT_NUMERIC_TEXT {
////        @Override
////        public boolean isCellValid(Cell cell){
////            if (cell.getCellType() != CellType.STRING) return false;
////            return FieldDataType.validate(cell.getStringCellValue());
////        }
////    }
//
//    ,DATE {
//        @Override
//        public boolean isCellValid(Cell cell) {
//            if (cell.getCellType() == CellType.STRING) return cell.getStringCellValue().equalsIgnoreCase("null");
//            Date date = cell.getDateCellValue();
//            return date != null;
//        }
//    }
//    ;
//
//    public abstract boolean isCellValid(Cell cell);
//}
