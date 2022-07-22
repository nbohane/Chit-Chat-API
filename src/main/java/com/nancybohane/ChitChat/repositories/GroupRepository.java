package com.nancybohane.ChitChat.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nancybohane.ChitChat.models.Group;
import com.nancybohane.ChitChat.models.Member;

public interface GroupRepository extends CrudRepository<Group, Integer>{

	@Query(
			value="SELECT G.*, M.id as member_id, M.is_admin FROM member M join usergroup G on M.group_id=G.id WHERE M.user_id=:userId",
			nativeQuery=true
			)
	Iterable<Group> findByUserId(int userId);
}
