package com.nancybohane.ChitChat.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nancybohane.ChitChat.models.Hashtag;

public interface HashtagRepository extends CrudRepository<Hashtag, Integer> {

	Iterable<Hashtag> findByText(String text);

	Iterable<Hashtag> findByPostId(int postId);
}
