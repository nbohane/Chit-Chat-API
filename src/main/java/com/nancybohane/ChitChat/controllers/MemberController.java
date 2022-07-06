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

import com.nancybohane.ChitChat.models.Member;
import com.nancybohane.ChitChat.repositories.MemberRepository;

@Controller
@CrossOrigin
@RequestMapping(path = "/members")
public class MemberController {
	@Autowired
	private MemberRepository memberRepository;

	// Create
	@PostMapping(path = "")
	public @ResponseBody Member createMember(@RequestBody Member member) {
		return memberRepository.save(member);
	}

	// Read by User ID
	@GetMapping(path = "/user")
	public @ResponseBody Iterable<Member> getMemberByUserId(@RequestParam int id) {
		return memberRepository.findByUserId(id);
	}

	// Read by Group ID
	@GetMapping(path = "/group")
	public @ResponseBody Iterable<Member> getMemberByGroupId(@RequestParam int id) {
		return memberRepository.findByGroupId(id);
	}

	// Update
	@PutMapping(path = "")
	public @ResponseBody String updateMember(@RequestBody Member member) {
		memberRepository.save(member);
		return "Member Updated Successfully!";
	}

	// Delete
	@DeleteMapping(path = "")
	public @ResponseBody String deleteMember(@RequestParam int id) throws Exception {
		try {
			memberRepository.deleteById(id);
			return "Deleted member!";
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new Exception("Could not delete member id#" + id);
	}

}
