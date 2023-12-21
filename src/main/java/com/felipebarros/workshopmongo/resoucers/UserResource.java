package com.felipebarros.workshopmongo.resoucers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.felipebarros.workshopmongo.domain.User;
import com.felipebarros.workshopmongo.services.UserSerrvice;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	@Autowired
	private UserSerrvice service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity< List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	
	}
	
	

}
