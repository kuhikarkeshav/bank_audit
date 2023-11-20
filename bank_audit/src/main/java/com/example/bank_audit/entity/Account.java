package com.example.bank_audit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String no;
    private String name;
    private String address;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "year_id")
    private Year year;

}
