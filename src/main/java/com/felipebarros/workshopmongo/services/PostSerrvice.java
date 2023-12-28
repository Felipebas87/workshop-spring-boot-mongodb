package com.felipebarros.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipebarros.workshopmongo.domain.Post;
import com.felipebarros.workshopmongo.dto.PostDTO;
import com.felipebarros.workshopmongo.repository.PostRepository;
import com.felipebarros.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostSerrvice {
	
	@Autowired
	private PostRepository repo;
	
	public List<Post> findAll(){
		return repo.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public Post insert(Post obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	
	}
	public Post update(Post obj) {
		Post newobj = findById(obj.getId());
		updateData(newobj, obj);
		return repo.save(newobj);
	
	}
	private void updateData(Post newobj, Post obj) {
		newobj.setTitle(obj.getTitle());
		newobj.setBody(obj.getBody());
	}


	
	public Post fromDTO(PostDTO objDTO) {
		return new Post(objDTO.getId(), objDTO.getDate(), objDTO.getBody(), objDTO.getTitle(), objDTO.getAuthor());
	}
	

}
