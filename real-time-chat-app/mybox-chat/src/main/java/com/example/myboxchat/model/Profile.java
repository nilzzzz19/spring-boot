package com.example.myboxchat.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Profile {

	@Id
	private String id;
	private String userId;
	private String bio;
	private String profilePicture;
	private String location;
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Profile(String id, String userId, String bio, String profilePicture, String location) {
		super();
		this.id = id;
		this.userId = userId;
		this.bio = bio;
		this.profilePicture = profilePicture;
		this.location = location;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
