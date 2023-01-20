package com.example.myboxchat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myboxchat.model.Chat;
import com.example.myboxchat.service.ChatService;

/*This class uses the @RestController annotation to indicate that it's a controller class that handles HTTP requests. 
The @RequestMapping annotation is used to map the controller to a specific URI.

The @Autowired annotation is used to automatically wire the ChatService bean.

The saveChat method is used to handle the POST request, it saves the chat object to the MongoDB collection by calling 
the saveChat method on the service.

The getAllChats method is used to handle the GET request, it retrieves all the chat object from the MongoDB collection 
by calling the getAllChats method on the service.

This class uses the @PostMapping and @GetMapping annotations to handle the POST and GET requests respectively.*/

@RestController
@RequestMapping("/chat")
public class ChatController {

	@Autowired
	private ChatService chatService;

	@PostMapping
	public void saveChat(@RequestBody Chat chat) {
		chatService.saveChat(chat);
	}

	@GetMapping
	public List<Chat> getAllChats() {
		return chatService.getAllChats();
	}

}
