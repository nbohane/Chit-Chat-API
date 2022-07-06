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

import com.nancybohane.ChitChat.models.Group;
import com.nancybohane.ChitChat.repositories.GroupRepository;

@Controller
@CrossOrigin
@RequestMapping(path = "/groups")
public class GroupController {
	@Autowired
	private GroupRepository groupRepository;

	// Create
	@PostMapping(path = "")
	public @ResponseBody Group createGroup(@RequestBody Group group) {
		return groupRepository.save(group);
	}

	// Read all
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Group> getAllGroups() {
		return groupRepository.findAll();
	}

	// Read by ID
	@GetMapping(path = "")
	public @ResponseBody Group getGroupById(@RequestParam int id) {
		return groupRepository.findById(id).get();
	}

	// Update
	@PutMapping(path = "")
	public @ResponseBody String updateGroup(@RequestBody Group group) {
		groupRepository.save(group);
		return "Group Updated Successfully!";
	}

	// Delete
	@DeleteMapping(path = "")
	public @ResponseBody String deleteGroup(@RequestParam int id) throws Exception {
		try {
			groupRepository.deleteById(id);
			return "Deleted group!";
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new Exception("Could not delete group id#" + id);
	}
}
