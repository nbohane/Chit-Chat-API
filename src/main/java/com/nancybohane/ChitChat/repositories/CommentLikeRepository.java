package com.nancybohane.ChitChat.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nancybohane.ChitChat.models.CommentLike;

public interface CommentLikeRepository extends CrudRepository<CommentLike, Integer> {

	Iterable<CommentLike> findByCommentId(int commentId);
}
