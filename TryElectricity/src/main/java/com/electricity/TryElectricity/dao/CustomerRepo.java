package com.electricity.TryElectricity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electricity.TryElectricity.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer>{

}
