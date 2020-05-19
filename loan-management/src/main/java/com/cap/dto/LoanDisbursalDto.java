package com.cap.dto;

import java.util.Date;

import javax.persistence.Id;

public class LoanDisbursalDto {

	    public String getLoanRequestId() {
		return loanRequestId;
	}

	public void setLoanRequestId(String loanRequestId) {
		this.loanRequestId = loanRequestId;
	}

	public String getLoanCustomerId() {
		return loanCustomerId;
	}

	public void setLoanCustomerId(String loanCustomerId) {
		this.loanCustomerId = loanCustomerId;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getLoan_amount_paid() {
		return loan_amount_paid;
	}

	public void setLoan_amount_paid(double loan_amount_paid) {
		this.loan_amount_paid = loan_amount_paid;
	}

	public Date getLoan_due_date() {
		return loan_due_date;
	}

	public void setLoan_due_date(Date loan_due_date) {
		this.loan_due_date = loan_due_date;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public double getEmi() {
		return emi;
	}

	public void setEmi(double emi) {
		this.emi = emi;
	}

	public int getLoanTenure() {
		return loanTenure;
	}

	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}

		@Id
	    private String loanRequestId;
	
		private String loanCustomerId;
		
		private double loanAmount;
		
		private double loan_amount_paid;
		
		private Date loan_due_date;
		
		private String loanType;
		
		private double emi;
		
		private int loanTenure;
}