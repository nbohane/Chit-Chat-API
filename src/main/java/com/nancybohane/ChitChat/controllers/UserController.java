package com.nancybohane.ChitChat.controllers;

import java.util.ArrayList;

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

import com.fasterxml.jackson.databind.JsonNode;
import com.nancybohane.ChitChat.models.User;
import com.nancybohane.ChitChat.repositories.UserRepository;

@Controller
@CrossOrigin
@RequestMapping(path = "/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	// Login
	@PostMapping(path = "/login")
	public @ResponseBody User login(@RequestBody JsonNode json) throws Exception {
		String email = json.get("email").asText();
		String password = json.get("password").asText();
		try {
			User dbUser = ((ArrayList<User>) userRepository.findByEmail(email)).get(0);

			if (dbUser.getPassword().equals(password)) {
				return dbUser;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("User does not exist");
		}
		throw new Exception("Incorrect password");
	}

	// Create
	@PostMapping(path = "")
	public @ResponseBody User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	// Read all
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	// Read by ID
	@GetMapping(path = "")
	public @ResponseBody User getUserById(@RequestParam int id) {
		return userRepository.findById(id).get();
	}

	// Update
	@PutMapping(path = "")
	public @ResponseBody String updateUser(@RequestBody User user) {
		userRepository.save(user);
		return "User Updated Successfully!";
	}

	// Delete
	@DeleteMapping(path = "")
	public @ResponseBody String deleteUser(@RequestParam int id) throws Exception {
		try {
			userRepository.deleteById(id);
			return "Deleted user!";
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new Exception("Could not delete user id#" + id);
	}

	// Read by Group ID
	@GetMapping(path = "/group")
	public @ResponseBody Iterable<User> getUserByGroupId(@RequestParam int id) {
		return userRepository.findByGroupId(id);
	}

	// Read by User ID
	@GetMapping(path = "/user")
	public @ResponseBody Iterable<User> getPostLikesByUserId(@RequestParam int id) {
		return userRepository.findByUserId(id);
	}

	// Read by Comment ID
	@GetMapping(path = "/comment")
	public @ResponseBody Iterable<User> getCommentLikeById(@RequestParam int id) {
		return userRepository.findByCommentId(id);
	}

	// Read by Post ID
	@GetMapping(path = "/post")
	public @ResponseBody Iterable<User> getPostLikesByPostId(@RequestParam int id) {
		return userRepository.findByPostId(id);
	}
}
