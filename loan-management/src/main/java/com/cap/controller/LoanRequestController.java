

package com.cap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cap.dto.CreateLoanRequestDto;
import com.cap.dto.LoanRequestDetailsDto;
import com.cap.entities.LoanRequest;
import com.cap.service.ILoanRequestService;
import com.cap.service.LoanRequestServiceImpl;

@RestController
@RequestMapping("/loanrequests")
public class LoanRequestController {
	
	@Autowired
	private ILoanRequestService service;
	
	

    @PostMapping("/add")
    public ResponseEntity<LoanRequestDetailsDto> add(@RequestBody CreateLoanRequestDto requestDto) {
        LoanRequest loanRequest = new LoanRequest();
        loanRequest.setLoanRequestId(requestDto.getLoanId());
        loanRequest.setLoanCustomerId(requestDto.getAccountId());
        loanRequest.setLoanAmount(requestDto.getLoanAmount());
        loanRequest.setLoanTenure(requestDto.getLoanTenure());
        loanRequest.setLoanType(requestDto.getLoanType());
        loanRequest.setCreditScore(requestDto.getCreditScore());
        
        
        loanRequest = service.save(loanRequest);
        LoanRequestDetailsDto dto = convertToDetailsDto(loanRequest);
        ResponseEntity<LoanRequestDetailsDto> response = new ResponseEntity<>(dto, HttpStatus.OK);
        return response;
    }
    
    
    @GetMapping("/get/{id}")
    public ResponseEntity<LoanRequestDetailsDto> add(@PathVariable("id") String id) {
        LoanRequest loanRequest = service.findById(id);
        LoanRequestDetailsDto dto = convertToDetailsDto(loanRequest);
        ResponseEntity<LoanRequestDetailsDto> response = new ResponseEntity<>(dto, HttpStatus.OK);
        return response;
    }
    
    
    @GetMapping(path = "/calculate/{amount}/{tenure}/{roi}")
        public ResponseEntity<Double> calculateEmi(@PathVariable("amount") Double amount,@PathVariable("tenure") Double tenure,@PathVariable("roi") Double roi ) {
        Double emi=service.calculateEmi(amount, tenure, roi);
        ResponseEntity<Double> response = new ResponseEntity<>(emi, HttpStatus.OK);
        return response;
    }    
    
    LoanRequestDetailsDto convertToDetailsDto(LoanRequest loanRequest) {
    	LoanRequestDetailsDto dto = new LoanRequestDetailsDto();
        dto.setAccountId(loanRequest.getLoanCustomerId());
        dto.setLoanAmount(loanRequest.getLoanAmount());
        dto.setLoanType(loanRequest.getLoanType());
        dto.setLoanTenure(loanRequest.getLoanTenure());
        return dto;
    }

}
