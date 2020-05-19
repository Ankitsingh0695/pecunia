package com.cap.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
	
	@Entity
	@Table(name="loandisbursal")
	public class LoanDisbursal  {
	
		    @Id
		    @NotNull
		    @Column(name="LoanRequestId")
		    private String loanRequestId;
		
		    @NotNull
		    @Column(name="Account_number")
			private String loanCustomerId;
			
			@NotNull
			@Size(min=1000, max=100000)
			@Column(name="LoanAmount")
			private double loanAmount;
			
			@Column(name="LoanPaid")
			private double loan_amount_paid;
			
			@Temporal(value=TemporalType.TIMESTAMP)
			@Column(name="LoanDueDate")
			private Date loan_due_date;
			
			@Column(name="LoanType")
			private String loanType;
			
			@Column(name="LoanEmi")
			private double emi;
			
			@Column(name="LoanTenure")
			private int loanTenure;
			
			
			
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
			public int getLoanTenure() {
				return loanTenure;
			}
			public void setLoanTenure(int loanTenure) {
				this.loanTenure = loanTenure;
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
			public String getLoanRequestId() {
				return loanRequestId;
			}
			public void setLoanRequestId(String loanRequestId) {
				this.loanRequestId = loanRequestId;
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
			
			 @Override
			    public boolean equals(Object o) {
			        if (this == o) return true;
			        if (o == null || getClass() != o.getClass()) return false;
			        LoanDisbursal customer = (LoanDisbursal) o;
			        return loanRequestId == customer.loanRequestId;
			    }

			    @Override
			    public int hashCode() {
			        return Objects.hash(loanRequestId);
			 
			    }
	}
