package com.nancybohane.ChitChat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nancybohane.ChitChat.models.Conversation;
import com.nancybohane.ChitChat.repositories.ConversationRepository;

@Controller
@CrossOrigin
@RequestMapping(path = "/conversations")
public class ConversationController {

	@Autowired
	private ConversationRepository conversationRepository;

	// Create
	@PostMapping(path = "")
	public @ResponseBody Conversation createConversation(@RequestBody Conversation conversation) {
		return conversationRepository.save(conversation);
	}

	// Update
	@PutMapping(path = "")
	public @ResponseBody String updateConversation(@RequestBody Conversation conversation) {
		conversationRepository.save(conversation);
		return "Conversation Updated Successfully!";
	}

	// Delete
	@DeleteMapping(path = "")
	public @ResponseBody String deleteConversation(@RequestParam int id) throws Exception {
		try {
			conversationRepository.deleteById(id);
			return "Deleted conversation!";
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new Exception("Could not delete conversation id#" + id);
	}
}
