package com.cbebank.calculated;

import org.springframework.web.multipart.MultipartFile;

public class Artist {
    private String name;
    private String email;
    private String bio;
    MultipartFile resume;
    
    
    public MultipartFile getResume() {
		return resume;
	}

	public void setResume(MultipartFile resume) {
		this.resume = resume;
	}

	// Constructors
    public Artist() {}

    public Artist(String name, String email, String bio, MultipartFile resume) {
    	this.email = email;
        this.bio = bio;
        this.name = name;
        this.resume = resume;
        
        
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
    
    
}
