package com.nancybohane.ChitChat.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Follower {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int followerId;
	private int beingFollowed;

	public Follower() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFollower() {
		return followerId;
	}

	public void setFollower(int followerId) {
		this.followerId = followerId;
	}

	public int getBeingFollowed() {
		return beingFollowed;
	}

	public void setBeingFollowed(int beingFollowed) {
		this.beingFollowed = beingFollowed;
	}

}
