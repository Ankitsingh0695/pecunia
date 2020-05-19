package com.cap.service;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.dao.IloanRequestDao;
import com.cap.entities.LoanRequest;
import com.cap.exceptions.AccountNotFoundException;


@Service
@Transactional
public class LoanRequestServiceImpl implements ILoanRequestService{

	
	@Autowired
	private IloanRequestDao dao;
	
	
	@Override
	public LoanRequest findById(String accountId) {
		 Optional<LoanRequest> optional=dao.findById(accountId);
	        if(optional.isPresent()) {
	            LoanRequest loanRequest=optional.get();
	            return loanRequest;
	        }
	        throw new AccountNotFoundException("no such account exists");
	    
	}

	@Override
	public LoanRequest save(LoanRequest loanRequest) {
		loanRequest=dao.save(loanRequest);
		return loanRequest;
	}

	@Override
	public Double calculateEmi(Double amount, Double tenure, Double roi) {
	     roi=roi/(12*100);
	     Double t=(double) (tenure*12);
	      Double amt=(amount*roi*Math.pow(1+roi,t))/(Math.pow(1+roi,t)-1);
	      return amt;
	     
	     
		
		

	}

}
