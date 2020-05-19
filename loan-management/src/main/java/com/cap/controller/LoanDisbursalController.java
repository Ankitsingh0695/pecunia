package com.cap.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cap.dto.LoanDisbursalDto;
import com.cap.dto.LoanRequestDetailsDto;
import com.cap.entities.LoanDisbursal;
import com.cap.entities.LoanRequest;
import com.cap.service.ILoanDisbursalService;

@RestController
@RequestMapping("/loanDisbursal")
public class LoanDisbursalController {
	
	@Autowired
	private ILoanDisbursalService service;
	
	
	
	
	@GetMapping("/loanDisbursal/retiveAll")
	public ResponseEntity<List<LoanRequestDetailsDto>> fetchAll()
	{
		 List<LoanRequest> loanRequest = service.retrieveAll();
		 List<LoanRequestDetailsDto> list = convertLoanRequestDetailsDto(loanRequest);
		 ResponseEntity<List<LoanRequestDetailsDto>> response = new ResponseEntity<>(list,HttpStatus.OK);
		 return response;
	}
	 
	
	
	@GetMapping("/loanDisbursal/aproveLoan")
	public ResponseEntity<List<LoanDisbursalDto>> approveLoan()
	{
		List<LoanDisbursal> loanDisbursal= service.approveLoan();
		List<LoanDisbursalDto>  list= convertLoanDisbursalDetailsDto(loanDisbursal);
		ResponseEntity<List<LoanDisbursalDto>> response = new ResponseEntity<>(list,HttpStatus.OK);
		return response;
	}
	
	
	@GetMapping("/get/{id}")
    public ResponseEntity<LoanDisbursalDto>  add(@PathVariable("id") String id) {
        LoanDisbursal loanDisbursal = service.findByLoanId(id);
        LoanDisbursalDto dto = convertLoanDisbursalDto(loanDisbursal);
        ResponseEntity<LoanDisbursalDto> response = new ResponseEntity<>(dto, HttpStatus.OK);
        return response;
    }
	
	
	
	@GetMapping("/loanDisbursal/approvedLoanList")
	public ResponseEntity<List<LoanDisbursalDto>> getApprovedList()
	{
		List<LoanDisbursal>  loanDisbursal = service.approvedLoanList();
		List<LoanDisbursalDto> list = convertLoanDisbursalDetailsDto(loanDisbursal);
		ResponseEntity<List<LoanDisbursalDto>> response = new ResponseEntity<>(list,HttpStatus.OK);
		return response;
	}
	
	
	
	@GetMapping("/loanDisbursal/rejectedList")
	public ResponseEntity<List<LoanRequestDetailsDto>> getRejectedList()
	{
		List<LoanRequest> loanDisbursal = service.rejectedLoanRequests();
		List<LoanRequestDetailsDto> list = convertLoanRequestDetailsDto(loanDisbursal);
		ResponseEntity<List<LoanRequestDetailsDto>> response = new ResponseEntity<>(list,HttpStatus.OK);
		return response;
		
	}
	
	private List<LoanRequestDetailsDto> convertLoanRequestDetailsDto(List<LoanRequest> loanDisbursal)
	{
		List<LoanRequestDetailsDto> list = new ArrayList();
		for(LoanRequest obj: loanDisbursal)
		{
			LoanRequestDetailsDto details = convertLoanRequestDto(obj);
			list.add(details);
			
			
		}
		return list;
	}
		
	
	
	
	public LoanRequestDetailsDto convertLoanRequestDto(LoanRequest loanRequest)
	{
		LoanRequestDetailsDto dto = new LoanRequestDetailsDto();
		dto.setLoanId(loanRequest.getLoanRequestId());
		dto.setAccountId(loanRequest.getLoanCustomerId());
		dto.setLoanAmount(loanRequest.getLoanAmount());
		dto.setLoanType(loanRequest.getLoanType());
		dto.setLoanTenure(loanRequest.getLoanTenure());
		dto.setLoanRoi(loanRequest.getloanRoi());
		dto.setLoanStatus(loanRequest.getLoanStatus());
		dto.setCreditScore(loanRequest.getCreditScore());
		
		return dto;
		
	}
	
	
	private List<LoanDisbursalDto> convertLoanDisbursalDetailsDto(List<LoanDisbursal> loanDisbursal)
	{
		List<LoanDisbursalDto> list = new ArrayList();
		for(LoanDisbursal obj: loanDisbursal)
		{
			LoanDisbursalDto details = convertLoanDisbursalDto(obj);
			list.add(details);
			
			
		}
		return list;
	}
	
	public LoanDisbursalDto convertLoanDisbursalDto(LoanDisbursal loanDisbursal)
	{
		LoanDisbursalDto dto = new LoanDisbursalDto();
		dto.setLoanRequestId(loanDisbursal.getLoanRequestId());
		dto.setLoanCustomerId(loanDisbursal.getLoanCustomerId());
		dto.setLoanAmount(loanDisbursal.getLoanAmount());
		dto.setLoanType(loanDisbursal.getLoanType());
		dto.setLoanTenure(loanDisbursal.getLoanTenure());
		return dto;
	}
	
	
	
	
	
	

}