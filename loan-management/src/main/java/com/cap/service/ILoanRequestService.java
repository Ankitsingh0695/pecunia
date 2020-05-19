package com.cap.service;

import com.cap.entities.LoanRequest;

public interface ILoanRequestService {

	
	LoanRequest findById(String loanCustomerId);
	LoanRequest save(LoanRequest loanRequest);
	Double calculateEmi(Double amount,Double tenure, Double roi );

}
