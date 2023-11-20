//package com.example.bank_audit.service;
//
//import java.io.IOException;
//import java.util.List;
//
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.example.bank_audit.dto.ExcelRowDtoMapper;
//import com.example.bank_audit.dto.StatutoryAuditDto;
//import com.example.bank_audit.entity.Branch;
//
//import com.example.bank_audit.enums.BulkModule;
//import com.example.bank_audit.utils.ExcelUtils;
//
//
//
//@Service
//
//public class ExcelProcessingFacade {
//	
//	@Autowired
//	private StatutoryAuditService statutoryAuditService;
//	@Autowired
//	 private  ExcelRowDtoMapper rowDtoMapper;
//
//	public void proceedExcelWithSelectedModules(MultipartFile uploadedFile) throws IOException {
//		Workbook workbook = new XSSFWorkbook(uploadedFile.getInputStream());
//	    proceedStatutoryAuditSheet(workbook);
//	}
//	
//	private void proceedStatutoryAuditSheet(Workbook workbook) {
//	   
//	    Sheet statutoryAuditSheet = workbook.getSheet("Statutory Audit");
//
//	    List<Row> rows = ExcelUtils.getSheetDataRows(statutoryAuditSheet);
//	    for (Row row : rows) {
//	        StatutoryAuditDto statutoryAuditDto = BulkModule.Statutory_Audit.mapRowToDto(row, StatutoryAuditDto.class);
//	        Branch entity = rowDtoMapper.rowDtoToStatutoryAudit(statutoryAuditDto);
//	        statutoryAuditService.saveOrUpdateIfExists(entity);
//	    }
//	}
//}
