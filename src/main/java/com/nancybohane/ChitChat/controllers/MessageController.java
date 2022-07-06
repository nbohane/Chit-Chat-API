package com.nancybohane.ChitChat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nancybohane.ChitChat.models.Message;
import com.nancybohane.ChitChat.models.User;
import com.nancybohane.ChitChat.repositories.MessageRepository;

@Controller
@CrossOrigin
@RequestMapping(path = "/messages")
public class MessageController {
	@Autowired
	private MessageRepository messageRepository;

	// Create
	@PostMapping(path = "")
	public @ResponseBody Message createMessage(@RequestBody Message message) {
		return messageRepository.save(message);
	}

	// Read by Conversation ID
	@GetMapping(path = "/conversation")
	public @ResponseBody Iterable<Message> getMessageByConversationId(@RequestParam int id) {
		return messageRepository.findByConversationId(id);
	}

	//Update Message
	@PutMapping(path = "")
	public @ResponseBody String updateMessage(@RequestBody Message message) {
		messageRepository.save(message);
		return "Message Updated Successfully!";
	}
}
