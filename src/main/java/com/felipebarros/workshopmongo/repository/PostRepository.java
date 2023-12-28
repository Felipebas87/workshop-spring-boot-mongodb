package com.felipebarros.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.felipebarros.workshopmongo.domain.Post;
import java.util.List;



public interface PostRepository extends MongoRepository<Post, String>{

	
	List<Post> findByTitleContainingIgnoreCase(String text);

}
