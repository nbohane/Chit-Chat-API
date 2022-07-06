package com.nancybohane.ChitChat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nancybohane.ChitChat.models.Mention;
import com.nancybohane.ChitChat.repositories.MentionRepository;

@Controller
@CrossOrigin
@RequestMapping(path = "/mentions")
public class MentionController {
	@Autowired
	private MentionRepository mentionRepository;

	// Create
	@PostMapping(path = "")
	public @ResponseBody Mention createMention(@RequestBody Mention mention) {
		return mentionRepository.save(mention);
	}

	// Read by User ID
	@GetMapping(path = "/user")
	public @ResponseBody Iterable<Mention> getMentionByUserId(@RequestParam int id) {
		return mentionRepository.findByUserId(id);
	}

	// Read by Post ID
	@GetMapping(path = "/post")
	public @ResponseBody Iterable<Mention> getMentionByPostId(@RequestParam int id) {
		return mentionRepository.findByPostId(id);
	}

	// Delete
	@DeleteMapping(path = "")
	public @ResponseBody String deleteConversation(@RequestParam int id) throws Exception {
		try {
			mentionRepository.deleteById(id);
			return "Deleted mention!";
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new Exception("Could not delete mention id#" + id);
	}
}
