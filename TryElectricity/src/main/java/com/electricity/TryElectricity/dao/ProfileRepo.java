package com.electricity.TryElectricity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electricity.TryElectricity.model.Profile;
@Repository
public interface ProfileRepo extends JpaRepository<Profile,Integer>{

}
