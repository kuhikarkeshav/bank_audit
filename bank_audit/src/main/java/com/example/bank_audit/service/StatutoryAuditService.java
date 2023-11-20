package com.example.bank_audit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank_audit.entity.Branch;

import com.example.bank_audit.repo.BranchRepo;
@Service
public class StatutoryAuditService {

	@Autowired
	private BranchRepo statutoryAuditRepo;
	
	public void saveOrUpdateIfExists(Branch entity) {
		// TODO Auto-generated method stub
		statutoryAuditRepo.save(entity);
	}

	public void saveOrUpdateIfExists1(List<Branch> branches) {
		// TODO Auto-generated method stub
		statutoryAuditRepo.saveAll(branches);
		
	}

	

}
