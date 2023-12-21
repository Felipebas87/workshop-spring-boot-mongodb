package com.felipebarros.workshopmongo.resoucers;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.felipebarros.workshopmongo.domain.User;
import com.felipebarros.workshopmongo.dto.UserDTO;
import com.felipebarros.workshopmongo.services.UserSerrvice;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	@Autowired
	private UserSerrvice service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity< List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listdto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listdto);
	
	}
	
	

}
