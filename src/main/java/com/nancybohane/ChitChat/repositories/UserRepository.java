package com.nancybohane.ChitChat.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nancybohane.ChitChat.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	@Query(
			value="SELECT U.*, M.id as member_id, M.is_admin FROM member M join user U on M.user_id=U.id WHERE M.group_id=:groupId",
			nativeQuery=true
			)
	Iterable<User> findByGroupId(int groupId);
	
	@Query(
			value="SELECT user.* FROM comment_like JOIN user ON user.id=comment_like.user_id WHERE comment_like.comment_id=:commentId",
			nativeQuery=true
			)
	Iterable<User> findByCommentId(int commentId);
	
	@Query(
			value="SELECT user.* FROM post_like JOIN user ON post_like.user_id=user.id WHERE post_like.post_id=:postId",
			nativeQuery=true
			)
	Iterable<User> findByPostId(int postId);

	@Query(
			value="SELECT post.* FROM post_like JOIN post ON post_like.post_id=post.id WHERE post_like.user_id=:userId",
			nativeQuery=true
			)
	Iterable<User> findByUserId(int userId);
	
	Iterable<User> findByEmail(String email);
}

