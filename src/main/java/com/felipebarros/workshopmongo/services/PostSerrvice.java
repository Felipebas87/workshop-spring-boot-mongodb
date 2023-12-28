package com.felipebarros.workshopmongo.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipebarros.workshopmongo.domain.Post;

import com.felipebarros.workshopmongo.repository.PostRepository;
import com.felipebarros.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostSerrvice {
	
	@Autowired
	private PostRepository repo;
	

	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}
}