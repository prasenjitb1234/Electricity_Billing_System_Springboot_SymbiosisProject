package com.electricity.TryElectricity.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.electricity.TryElectricity.model.Profile;
import com.electricity.TryElectricity.services.ProfileServices;

@Controller
public class profilepicController {

	@Autowired
    ProfileServices profServices;
	
	private static int id;
	
	@GetMapping("/profileImage")
    public String getProfileForm() {
        return "profile"; 
    }
	
	
	@PostMapping("/uploadProfileImage")
    public String getUpload(@RequestParam("image") MultipartFile imgFile) {
        if (!imgFile.isEmpty()) {
            Profile profile = new Profile();
            try {
            	profile.setId(id);
                profile.setImage(imgFile.getBytes());
                profServices.setProfile(profile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "check"; 
    }
	
	public int getId() {
        return id;
    }

    public static void setId(int userID) {
        id = userID;
    }
	
}
