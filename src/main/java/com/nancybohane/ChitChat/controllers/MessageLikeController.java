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

import com.nancybohane.ChitChat.models.MessageLike;
import com.nancybohane.ChitChat.models.Post;
import com.nancybohane.ChitChat.repositories.MessageLikeRepository;
import com.nancybohane.ChitChat.repositories.PostRepository;
@Controller
@CrossOrigin
@RequestMapping(path = "/messagelikes")
public class MessageLikeController {
	@Autowired
	private MessageLikeRepository messageLikeRepository;

	// Create
	@PostMapping(path = "")
	public @ResponseBody MessageLike createMessageLike(@RequestBody MessageLike messageLike) {
		return messageLikeRepository.save(messageLike);
	}

	// Read by Message ID
	@GetMapping(path = "")
	public @ResponseBody Iterable<MessageLike> getMessageLikesByMessageId(@RequestParam int id) {
		return messageLikeRepository.findByMessageId(id);
	}

	// Delete
	@DeleteMapping(path = "")
	public @ResponseBody String deleteMessageLike(@RequestParam int id) throws Exception {
		try {
			messageLikeRepository.deleteById(id);
			return "Deleted message like!";
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new Exception("Could not delete message like id#" + id);
	}
}
