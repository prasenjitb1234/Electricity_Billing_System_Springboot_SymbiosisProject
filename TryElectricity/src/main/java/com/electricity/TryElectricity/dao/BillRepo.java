package com.electricity.TryElectricity.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electricity.TryElectricity.model.Bill;

@Repository
public interface BillRepo extends JpaRepository<Bill, Integer>{
	 List<Bill> findByCustomerId(int customerId);
}	
