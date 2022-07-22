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

import com.nancybohane.ChitChat.models.PostLike;
import com.nancybohane.ChitChat.repositories.PostLikeRepository;

@Controller
@CrossOrigin
@RequestMapping(path = "/postlikes")
public class PostLikeController {

	@Autowired
	private PostLikeRepository postLikeRepository;

	// Create
	@PostMapping(path = "")
	public @ResponseBody PostLike createPostLike(@RequestBody PostLike postLike) {
		return postLikeRepository.save(postLike);
	}

	// Delete
	@DeleteMapping(path = "")
	public @ResponseBody String deletePostLike(@RequestParam int id) throws Exception {
		try {
			postLikeRepository.deleteById(id);
			return "Deleted Post like!";
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new Exception("Could not delete post like id#" + id);
	}

}
