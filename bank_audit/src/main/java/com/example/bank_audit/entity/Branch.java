package com.example.bank_audit.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Entity
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    
    private String tahsil;
    
    private Boolean pacsAttach;
    
    //private int noOfPacs;
    
    private Boolean atmAttach;
    
    private Boolean lockerFacility;
    
    private Boolean goldLoanFacility;
    
    private int hasAccountWithSBIBeforeNov2021;
    private int hasAccountWithSBIAfterDec2021;
    private int cashRetentionLimitBeforeMay2022;
    private int cashRetentionLimitAfterJun2022;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    private Boolean active = true;


}
