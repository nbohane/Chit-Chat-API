package com.nancybohane.ChitChat.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nancybohane.ChitChat.models.Conversation;

public interface ConversationRepository extends CrudRepository<Conversation, Integer>{

}
