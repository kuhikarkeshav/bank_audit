package com.example.bank_audit.controller;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.bank_audit.entity.Bank;
import com.example.bank_audit.entity.Branch;
import com.example.bank_audit.entity.LoanDetail;
import com.example.bank_audit.entity.Year;

import com.example.bank_audit.service.ExcelService;
import com.example.bank_audit.service.StatutoryAuditService;
@RestController
@RequestMapping("/file")
public class AuditController {
	
//	 @Autowired
//	    private ExcelProcessingFacade excelProcessingFacade;
	 
	 @Autowired
	    private StatutoryAuditService statutoryAuditService;
	 
	 @Autowired
	    private ExcelService excelService;

//	@PostMapping(value = "/upload")
//    public String proceedBulkSheet(
//                                           @RequestPart MultipartFile fileUpload
//                                          ) throws Exception {
//
//        
//        //List<BulkModule> selectedModules = BulkModule.getSelectedModules(allRequiredModules, selectedModulesNames);
//        excelProcessingFacade.proceedExcelWithSelectedModules(fileUpload);
//
//        return "success";
//    }
	
	@PostMapping(value = "/upload2")
	public String importExcelData(@RequestParam("fileUpload") MultipartFile fileUpload) {
	    try {
	        excelService.saveDataToTables(fileUpload,  Branch.class);
	        return "Data imported successfully!";
	    } catch (IOException e) {
	        e.printStackTrace();
	        return "Error importing data: " + e.getMessage();
	    }
	}
    
}
