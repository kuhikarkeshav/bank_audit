//package com.example.bank_audit.enums;
//
//import java.util.List;
//
//import org.apache.poi.ss.usermodel.Row;
//import org.springframework.jdbc.core.RowCallbackHandler;
//
//import com.example.bank_audit.dto.ExcelRowDto;
//import com.example.bank_audit.dto.StatutoryAuditDto;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//
//@Getter
//@AllArgsConstructor
//public enum BulkModule {
//
//	Statutory_Audit(1, "Statutory Audit", true, 21, StatutoryAuditDto.class);
//	
//	 final int orderNumber;
//	    /**
//	     * Name of required {@link org.apache.poi.ss.usermodel.Sheet} in Workbook.
//	     */
//	    final String tabName;
//	    /**
//	     * Parameter used for getModuleList() methods
//	     */
//	    final boolean obligatory;
//	    /**
//	     * Number of required columns in Sheet validation
//	     */
//	    final int numberOfColumns;
//	    /**
//	     * ExcelRowDto inheriting class - target class for Row mapping method
//	     */
//	    final Class<? extends ExcelRowDto> inheritingDtoClass; // TODO: consider if necessary
//
//	    public <T extends ExcelRowDto> T mapRowToDto(Row row, Class<T> dtoClass) {
//	        List<ColumnConfig> columns = ColumnConfig.getListByModule(this);
//	        
//	        if (this == Statutory_Audit) {
//	            var statutoryAuditDto = new StatutoryAuditDto();
//	            columns.forEach(column -> column.mapRowValue(statutoryAuditDto, (Row) row));
//	            return dtoClass.cast(statutoryAuditDto);
//	        }
//	        
//	        throw new IllegalArgumentException("Unsupported module: " + this);
//	    }
//
//}
