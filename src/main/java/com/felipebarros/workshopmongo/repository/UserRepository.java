package com.felipebarros.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.felipebarros.workshopmongo.domain.User;


public interface UserRepository extends MongoRepository<User, String>{

	
	

}
