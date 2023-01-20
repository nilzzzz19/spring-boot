package com.example.myboxchat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myboxchat.model.Chat;
import com.example.myboxchat.repository.ChatRepository;

/*This class uses the @Service annotation to indicate that it's a service class. 
The @Autowired annotation is used to automatically wire the ChatRepository bean.

The saveChat method is used to save a chat object to the MongoDB collection by 
calling the save method on the repository.

The getAllChats method is used to retrieve all the chat object from the 
MongoDB collection by calling the findAll method on the repository.
*/
@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public void saveChat(Chat chat) {
        chatRepository.save(chat);
    }

    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }
}

/*
 * The service layer of your application should contain the business logic, that
 * is, the code that performs operations on the data and applies the rules of
 * the application. This class is a good example of how to separate the service
 * layer from the data access layer using the repository pattern, which allows
 * you to change the data storage technology without affecting the service
 * layer.
 */