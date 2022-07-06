package com.nancybohane.ChitChat.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nancybohane.ChitChat.models.Participant;

public interface ParticipantRepository extends CrudRepository<Participant, Integer> {

	Iterable<Participant> findByConversationId(int conversationId);

	Iterable<Participant> findByUserId(int userId);
}
