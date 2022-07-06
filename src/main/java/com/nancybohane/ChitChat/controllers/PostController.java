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

import com.nancybohane.ChitChat.models.Post;
import com.nancybohane.ChitChat.repositories.PostRepository;

@Controller
@CrossOrigin
@RequestMapping(path = "/posts")
public class PostController {

	@Autowired
	private PostRepository postRepository;

	// Create
	@PostMapping(path = "")
	public @ResponseBody Post createPost(@RequestBody Post post) {
		return postRepository.save(post);
	}

	// Read by ID
	@GetMapping(path = "")
	public @ResponseBody Post getPostById(@RequestParam int id) {
		return postRepository.findById(id).get();
	}

	// Update
	@PutMapping(path = "")
	public @ResponseBody String updatePost(@RequestBody Post post) {
		postRepository.save(post);
		return "Post Updated Successfully!";
	}

	// Delete
	@DeleteMapping(path = "")
	public @ResponseBody String deletePost(@RequestParam int id) throws Exception {
		try {
			postRepository.deleteById(id);
			return "Deleted post!";
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new Exception("Could not delete post id#" + id);
	}
}
