package com.ninjaone.backendinterviewproject.database;

import org.springframework.stereotype.Repository;

import com.ninjaone.backendinterviewproject.model.User;

//@Repository
public interface UserRepository extends IGenericRepo<User, Integer> {
	//select * from usuario where username = ?
	User findOneByUserName(String userName);	
}
