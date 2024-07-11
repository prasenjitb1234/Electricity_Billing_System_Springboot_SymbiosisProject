package com.electricity.TryElectricity.services;

import com.electricity.TryElectricity.model.Profile;

public interface ProfileServices {

	public Profile setProfile(Profile profile);

	public Profile getById(int id);

	public boolean existById(int id);

}
