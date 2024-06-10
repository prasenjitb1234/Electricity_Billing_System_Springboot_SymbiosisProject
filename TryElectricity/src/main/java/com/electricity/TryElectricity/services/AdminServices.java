package com.electricity.TryElectricity.services;

import java.util.List;

import com.electricity.TryElectricity.model.Admin;

public interface AdminServices {
	
	public Admin saveRegistered(Admin admin);
	
	public List<Admin> adminList();
	
}
