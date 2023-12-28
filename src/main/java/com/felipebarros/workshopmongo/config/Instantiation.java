package com.felipebarros.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.felipebarros.workshopmongo.domain.Post;
import com.felipebarros.workshopmongo.domain.User;
import com.felipebarros.workshopmongo.dto.AuthorDTO;
import com.felipebarros.workshopmongo.repository.PostRepository;
import com.felipebarros.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		Post post1 = new Post(null, sdf.parse("21/03/2023"), "Férias", "muito boa a viagem", new AuthorDTO(maria) );
		Post post2 = new Post(null, sdf.parse("01/06/2023"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(alex) );
		
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().add(post1);
		alex.getPosts().add(post2);
		userRepository.saveAll(Arrays.asList(maria, alex));
						
	}

}
