package com.khatabook.dao;

import org.springframework.data.repository.CrudRepository;

import com.khatabook.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
}
