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

import com.nancybohane.ChitChat.models.CommentLike;
import com.nancybohane.ChitChat.repositories.CommentLikeRepository;

@Controller
@CrossOrigin
@RequestMapping(path = "/commentlikes")
public class CommentLikeController {

	@Autowired
	private CommentLikeRepository commentLikeRepository;

	// Create
	@PostMapping(path = "")
	public @ResponseBody CommentLike createCommentLike(@RequestBody CommentLike commentlike) {
		return commentLikeRepository.save(commentlike);
	}

	// Read by Comment ID
	@GetMapping(path = "")
	public @ResponseBody Iterable<CommentLike> getCommentLikeById(@RequestParam int id) {
		return commentLikeRepository.findByCommentId(id);
	}

	// Delete
	@DeleteMapping(path = "")
	public @ResponseBody String deleteCommentLike(@RequestParam int id) throws Exception {
		try {
			commentLikeRepository.deleteById(id);
			return "Deleted comment like!";
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new Exception("Could not delete comment like id#" + id);
	}
}
