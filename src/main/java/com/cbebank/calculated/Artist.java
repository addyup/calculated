package com.cbebank.calculated;


public class Artist {
    private String name;
    private String email;
    private String bio;
    // Constructors
    public Artist() {}

    public Artist(String name, String email, String bio) {
    	this.email = email;
        this.bio = bio;
        this.name = name;
        
        
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
