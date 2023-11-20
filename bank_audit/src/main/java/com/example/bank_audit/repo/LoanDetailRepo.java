package com.example.bank_audit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bank_audit.entity.LoanDetail;

@Repository
public interface LoanDetailRepo extends JpaRepository<LoanDetail, Integer>{

}
