package com.electricity.TryElectricity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electricity.TryElectricity.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer>{

	
}
