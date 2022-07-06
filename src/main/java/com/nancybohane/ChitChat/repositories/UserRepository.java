package com.nancybohane.ChitChat.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nancybohane.ChitChat.models.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
