package com.nancybohane.ChitChat.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nancybohane.ChitChat.models.Post;

public interface PostRepository extends CrudRepository<Post, Integer>{

}
