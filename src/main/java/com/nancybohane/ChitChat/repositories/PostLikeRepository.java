package com.nancybohane.ChitChat.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nancybohane.ChitChat.models.PostLike;

public interface PostLikeRepository extends CrudRepository<PostLike, Integer> {

	Iterable<PostLike> findByPostId(int postId);

	Iterable<PostLike> findByUserId(int userId);

}
