package com.felipebarros.workshopmongo.resoucers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.felipebarros.workshopmongo.domain.Post;
import com.felipebarros.workshopmongo.dto.PostDTO;
import com.felipebarros.workshopmongo.services.PostSerrvice;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	@Autowired
	private PostSerrvice service;
	
	@GetMapping
	public ResponseEntity< List<PostDTO>> findAll(){
		List<Post> list = service.findAll();
		List<PostDTO> listdto = list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listdto);
	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PostDTO> findById(@PathVariable String id ){
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(new PostDTO(obj));
	
	}
	
	@PostMapping
	public ResponseEntity<PostDTO> insert(@RequestBody PostDTO objDTO ){
		Post obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id ){
		service.delete(id);
		return ResponseEntity.noContent().build();	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PostDTO> update(@RequestBody PostDTO objDTO, @PathVariable String id  ){
		Post obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();	
	}
	
	
	
	
	

}
