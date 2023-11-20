package com.example.bank_audit.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatutoryAuditDto {

	 private String name;
	 private String tahsil;
	 private Date date;
	 private String attended_by;
	 
	 private Boolean pacsAttach;
	    
	    private int noOfPacs;
	    
	    private Boolean atmAttach;
	    
	    private Boolean lockerFacility;
	    
	    private Boolean goldLoanFacility;
	    
	    private int hasAccountWithSBIBeforeNov2021;
	    private int hasAccountWithSBIAfterDec2021;
	    private int cashRetentionLimitBeforeMay2022;
	    private int cashRetentionLimitAfterJun2022;
	 
	
}
