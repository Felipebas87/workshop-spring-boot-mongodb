package com.felipebarros.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipebarros.workshopmongo.domain.User;
import com.felipebarros.workshopmongo.repository.UserRepository;

@Service
public class UserSerrvice {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}

}
