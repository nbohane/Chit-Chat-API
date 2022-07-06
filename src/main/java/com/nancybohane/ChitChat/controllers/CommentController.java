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

import com.nancybohane.ChitChat.models.Comment;
import com.nancybohane.ChitChat.repositories.CommentRepository;

@Controller
@CrossOrigin
@RequestMapping(path = "/comments")
public class CommentController {
	
		@Autowired
		private CommentRepository commentRepository;

		// Create
		@PostMapping(path = "")
		public @ResponseBody Comment createComment(@RequestBody Comment comment) {
			return commentRepository.save(comment);
		}

		// Read by Post ID
		@GetMapping(path = "/post")
		public @ResponseBody Iterable<Comment> getCommentById(@RequestParam int id) {
			return commentRepository.findByPostId(id);
		}

		// Update
		@PutMapping(path = "")
		public @ResponseBody String updateComment(@RequestBody Comment comment) {
			commentRepository.save(comment);
			return "Comment Updated Successfully!";
		}

		// Delete
		@DeleteMapping(path = "")
		public @ResponseBody String deleteComment(@RequestParam int id) throws Exception {
			try {
				commentRepository.deleteById(id);
				return "Deleted comment!";
			} catch (Exception e) {
				e.printStackTrace();
			}
			throw new Exception("Could not delete comment id#" + id);
		}
	}
