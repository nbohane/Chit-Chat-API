package com.nancybohane.ChitChat.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nancybohane.ChitChat.models.Message;

public interface MessageRepository extends CrudRepository<Message, Integer>{

	Iterable<Message> findByConversationId(int conversationId);
}
