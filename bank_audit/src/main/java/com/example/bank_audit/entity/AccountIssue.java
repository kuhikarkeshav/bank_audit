package com.example.bank_audit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account_issue")
public class AccountIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "issue_id")
    private AnnexureIssue issue;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    private String remarks;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
