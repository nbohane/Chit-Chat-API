package com.nancybohane.ChitChat.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nancybohane.ChitChat.models.Follower;

public interface FollowerRepository extends CrudRepository<Follower, Integer> {

	Iterable<Follower> findFollowingByFollowerId(int followerId);

	Iterable<Follower> findBeingFollowedByFollowerId(int beingFollowed);
}
