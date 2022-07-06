package com.nancybohane.ChitChat.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nancybohane.ChitChat.models.MessageLike;

public interface MessageLikeRepository extends CrudRepository<MessageLike, Integer> {
	Iterable<MessageLike> findByMessageId(int messageId);

}
