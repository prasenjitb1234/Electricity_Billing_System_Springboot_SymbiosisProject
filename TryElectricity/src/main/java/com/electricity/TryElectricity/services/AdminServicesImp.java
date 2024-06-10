package com.electricity.TryElectricity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity.TryElectricity.dao.AdminRepo;
import com.electricity.TryElectricity.model.Admin;

@Service
public class AdminServicesImp implements AdminServices{

	@Autowired
	private AdminRepo adminRepo;
	
	@Override
	public Admin saveRegistered(Admin admin) {
		return adminRepo.save(admin);
	}

	@Override
	public List<Admin> adminList() {
		List<Admin> findAll = adminRepo.findAll();
		return findAll;
	}

}
