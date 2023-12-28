package com.felipebarros.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.felipebarros.workshopmongo.domain.Post;


public interface PostRepository extends MongoRepository<Post, String>{

	
	

}
