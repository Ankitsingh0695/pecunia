package com.cap.service;

import java.util.ArrayList;
import java.util.List;

import com.cap.entities.LoanDisbursal;
import com.cap.entities.LoanRequest;

public interface ILoanDisbursalService {

	public LoanDisbursal findByLoanId(String id);
	public ArrayList<LoanRequest> retrieveAll();
	public ArrayList<LoanDisbursal> approveLoan();
	public ArrayList<LoanDisbursal> approvedLoanList();
	public List<LoanRequest> rejectedLoanRequests();
	public String updateLoanAccount(String accountId , Double amount);
	
	
}