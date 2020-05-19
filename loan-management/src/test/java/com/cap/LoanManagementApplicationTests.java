package com.cap;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cap.entities.LoanRequest;
import com.cap.exceptions.AccountNotFoundException;
import com.cap.service.ILoanRequestService;
import com.cap.service.LoanRequestServiceImpl;
@DataJpaTest
@ExtendWith(SpringExtension.class)
@Import(LoanRequestServiceImpl.class)
@SpringBootTest
class LoanManagementApplicationTests {
    @Autowired
	private ILoanRequestService loanRequestService;
	
    @Autowired
    EntityManager entityManager;
    
    
	//case when loan request does not exist in databse 
    @Test
    public void testSaveLoanRequest() {
    
    	String loanId="100",accountId="200";
    	LoanRequest loanRequest=new LoanRequest();
    	loanRequest.setLoanRequestId(loanId);
    	loanRequest.setLoanCustomerId(accountId);
    	LoanRequest result=loanRequestService.save(loanRequest);
    	List<LoanRequest> fetched = entityManager.createQuery("from loanrequest").getResultList();
        Assertions.assertEquals(1, fetched.size());// verifying one got inserted
        LoanRequest expected = fetched.get(0);
        Assertions.assertEquals(expected, result);// verifying fetch and stored are equal
        Assertions.assertEquals(loanId, expected.getLoanRequestId());
        Assertions.assertEquals(accountId, expected.getLoanCustomerId());
    	
    }
    
    @Test
    public void testFindById() {
        //Executable class is in junit, don't choose the other one
    	 Executable executable=new Executable() 
    	 {
    	        @Override public void execute() throws Throwable
    	        {
    	        loanRequestService.findById("100");
    	        }
    	  };   
    	        
    	  Assertions.assertThrows(AccountNotFoundException.class, executable);

    }

    
    
    
	@Test
	void contextLoads() {
	}

}
