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

import com.nancybohane.ChitChat.models.Follower;
import com.nancybohane.ChitChat.repositories.FollowerRepository;

@Controller
@CrossOrigin
@RequestMapping(path = "/followers")
public class FollowerController {
	@Autowired
	private FollowerRepository followerRepository;

	// Create
	@PostMapping(path = "")
	public @ResponseBody Follower createFollower(@RequestBody Follower follower) {
		return followerRepository.save(follower);
	}

	// Read by follower ID
	@GetMapping(path = "/following")
	public @ResponseBody Iterable<Follower> getFollowingByFollowerId(@RequestParam int id) {
		return followerRepository.findFollowingByFollowerId(id);
	}

	// Read by follower ID
	@GetMapping(path = "/beingfollowed")
	public @ResponseBody Iterable<Follower> getBeingFollowedByFollowerId(@RequestParam int id) {
		return followerRepository.findBeingFollowedByFollowerId(id);
	}

	// Delete
	@DeleteMapping(path = "")
	public @ResponseBody String deleteConversation(@RequestParam int id) throws Exception {
		try {
			followerRepository.deleteById(id);
			return "Deleted follower!";
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new Exception("Could not delete follower id#" + id);
	}
}
