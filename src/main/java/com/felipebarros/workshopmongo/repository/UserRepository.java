package com.felipebarros.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.felipebarros.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	

}
