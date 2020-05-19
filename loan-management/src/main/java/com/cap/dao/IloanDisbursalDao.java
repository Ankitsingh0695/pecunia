package com.cap.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.entities.LoanDisbursal;


@Repository
public interface IloanDisbursalDao extends JpaRepository<LoanDisbursal, String> {

}
