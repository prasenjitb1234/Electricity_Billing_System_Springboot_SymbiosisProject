package com.electricity.TryElectricity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity.TryElectricity.dao.ComplaintRepository;
import com.electricity.TryElectricity.model.Complaint;

@Service
public class ComplaintServiceImp implements ComplaintService  {
	
	
	 @Autowired
	    private ComplaintRepository complaintRepository;


	@Override
	public Complaint saveComplaint(Complaint complaint) {
		// TODO Auto-generated method stub
		return complaintRepository.save(complaint);
	}

	@Override
	public List<Complaint> getAllComplaints() {
		// TODO Auto-generated method stub
		return complaintRepository.findAll();
	}

}
