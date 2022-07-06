package com.nancybohane.ChitChat.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nancybohane.ChitChat.models.Mention;

public interface MentionRepository extends CrudRepository<Mention, Integer> {

	Iterable<Mention> findByUserId(int userId);

	Iterable<Mention> findByPostId(int postId);
}
