package com.example.myboxchat.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.myboxchat.model.Chat;

/*This interface extends MongoRepository interface,
which provides a basic set of CRUD operations for MongoDB out of the box.*/

@Repository
public interface ChatRepository extends MongoRepository<Chat, String> {

	public void saveChat(Chat chat);
	public List<Chat> getAllChats();
}
