package com.cap.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.entities.LoanRequest;


@Repository
public interface IloanRequestDao extends JpaRepository<LoanRequest, String>{



}
