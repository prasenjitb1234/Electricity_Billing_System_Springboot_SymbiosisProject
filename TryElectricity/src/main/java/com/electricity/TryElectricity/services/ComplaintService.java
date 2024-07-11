package com.electricity.TryElectricity.services;

import java.util.List;

import com.electricity.TryElectricity.model.Complaint;

public interface ComplaintService {

	Complaint saveComplaint(Complaint complaint);
    List<Complaint> getAllComplaints();
}
