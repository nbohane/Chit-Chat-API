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

import com.nancybohane.ChitChat.models.Participant;
import com.nancybohane.ChitChat.repositories.ParticipantRepository;

@Controller
@CrossOrigin
@RequestMapping(path = "/participants")
public class ParticipantController {
	@Autowired
	private ParticipantRepository participantRepository;

	// Create
	@PostMapping(path = "")
	public @ResponseBody Participant createParticipant(@RequestBody Participant participant) {
		return participantRepository.save(participant);
	}

	// Read by Conversation ID
	@GetMapping(path = "/conversation")
	public @ResponseBody Iterable<Participant> getParticipantByConversationId(@RequestParam int id) {
		return participantRepository.findByConversationId(id);
	}

	// Read by User ID
	@GetMapping(path = "/user")
	public @ResponseBody Iterable<Participant> getParticipantByUserId(@RequestParam int id) {
		return participantRepository.findByUserId(id);
	}

	// Delete
	@DeleteMapping(path = "")
	public @ResponseBody String deleteParticipant(@RequestParam int id) throws Exception {
		try {
			participantRepository.deleteById(id);
			return "Deleted participant!";
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new Exception("Could not delete participant id#" + id);
	}
}
