package com.nancybohane.ChitChat.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nancybohane.ChitChat.models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer>{

	Iterable<Comment> findByPostId(int postId);
	
}
