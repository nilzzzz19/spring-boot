package com.example.myboxchat.websocket;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

/*This class uses the @ServerEndpoint annotation to specify the WebSocket endpoint URL 
and the @OnOpen, @OnMessage, @OnClose, and @OnError annotations to handle the WebSocket
lifecycle events.

The onOpen method is called when a new WebSocket connection is established. 
It adds the new session to the set of active sessions.

The onMessage method is called when a new message is received over the WebSocket connection. 
It broadcast the message to all the connected clients.

The onClose method is called when a WebSocket connection is closed. 
It removes the session from the set of active sessions.

The onError method is called when an error occurs during the WebSocket connection. 
It logs the error message.

This class uses a static set to keep track of all the connected clients, each client is 
represented by a Session object, which provides methods for sending and receiving messages, 
and for closing the connection. */

@ServerEndpoint("/chat")
public class ChatEndpoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChatEndpoint.class);

	private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

	@OnOpen
	public void onOpen(Session session) {
		LOGGER.info("New session opened: {}", session.getId());
		sessions.add(session);
	}

	@OnMessage
	public void onMessage(String message, Session session) {
		LOGGER.info("New message from session {}: {}", session.getId(), message);
		for (Session s : sessions) {
			if (s.isOpen()) {
				s.getAsyncRemote().sendText(message);
			}
		}
	}

	@OnClose
	public void onClose(Session session) {
		LOGGER.info("Session closed: {}", session.getId());
		sessions.remove(session);
	}

	@OnError
	public void onError(Session session, Throwable t) {
		LOGGER.error("Error on session {}: {}", session.getId(), t.getMessage());
	}
}
