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

import com.nancybohane.ChitChat.models.Hashtag;
import com.nancybohane.ChitChat.repositories.HashtagRepository;

@Controller
@CrossOrigin
@RequestMapping(path = "/hashtags")
public class HashtagController {
	@Autowired
	private HashtagRepository hashtagRepository;

	// Create
	@PostMapping(path = "")
	public @ResponseBody Hashtag createHashtag(@RequestBody Hashtag hashtag) {
		return hashtagRepository.save(hashtag);
	}

	// Read by String
	@GetMapping(path = "/hashtag")
	public @ResponseBody Iterable<Hashtag> getHashtagByText(@RequestParam String text) {
		return hashtagRepository.findByText(text);
	}

	// Read by Post ID
	@GetMapping(path = "/post")
	public @ResponseBody Iterable<Hashtag> getHashtagByPostId(@RequestParam int id) {
		return hashtagRepository.findByPostId(id);
	}

	// Delete
	@DeleteMapping(path = "")
	public @ResponseBody String deleteHashtag(@RequestParam int id) throws Exception {
		try {
			hashtagRepository.deleteById(id);
			return "Deleted hashtag!";
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new Exception("Could not delete hashtag id#" + id);
	}
}
