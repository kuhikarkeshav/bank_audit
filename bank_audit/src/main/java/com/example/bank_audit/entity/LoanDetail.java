package com.example.bank_audit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account_loan_Details")
public class LoanDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String branch;
    private String headName;
    private String accountNo;
    private String customerName;
    private double interestRate;
    private Date appraisalSanctionDate;
    private Date disbursementDate;
    private double loanAmount;
    private Date expiryDate;
    private double balance;
    private String npaClassDescription;
    @Column(columnDefinition = "TEXT")
    private String detailsToBeVerified;
    @Column(columnDefinition = "TEXT")
    private String remark;
}
