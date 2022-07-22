package com.nancybohane.ChitChat.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nancybohane.ChitChat.models.Member;

public interface MemberRepository extends CrudRepository<Member, Integer> {

	
}
