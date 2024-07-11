package com.electricity.TryElectricity.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity.TryElectricity.dao.ProfileRepo;
import com.electricity.TryElectricity.model.Profile;

@Service
public class ProfileServicesImp implements ProfileServices{
	@Autowired
	private ProfileRepo profileRepo;
	
	@Override
	public Profile setProfile(Profile profile) {
		// TODO Auto-generated method stub
		return profileRepo.save(profile);
	}

	@Override
	public Profile getById(int id) {
		Optional<Profile> findById = profileRepo.findById(id);
		Profile profile = findById.get();
		return profile;
	}

	@Override
	public boolean existById(int id) {
		// TODO Auto-generated method stub
		return profileRepo.existsById(id);
	}

}
