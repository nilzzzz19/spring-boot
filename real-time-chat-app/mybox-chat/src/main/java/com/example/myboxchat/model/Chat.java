package com.example.myboxchat.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "chat")
public class Chat {
	   @Id
	    private String id;
	    private String username;
	    private String message;
	    private Date timestamp;
		public Chat() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Chat(String id, String username, String message, Date timestamp) {
			super();
			this.id = id;
			this.username = username;
			this.message = message;
			this.timestamp = timestamp;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public Date getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}

}
