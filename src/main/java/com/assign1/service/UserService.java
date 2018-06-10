package com.assign1.service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.assign1.model.Users;
import com.assign1.model.UserNotFoundException;
import com.assign1.repo.UserRepository;

@RestController
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	// Retrieve = R
	//@GetMapping("/users/{id}")
	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public List<Users> getAllUser(){
		return userRepository.findAll();
	}
	
	// Retrieve = R
	//@GetMapping("/users/id")
	@RequestMapping(method=RequestMethod.GET, value="/users/{id}")
	public Resource<Users> getUser(@PathVariable Long id){
		Optional<Users> user = userRepository.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException("User Id is not Present "+ id);
		
		Resource<Users> resource = new Resource<Users>(user.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUser());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}
	
	// Delete = D
	//@DeleteMapping("/user/{id}")
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	public void deleteUser(@PathVariable Long id){
		userRepository.deleteById(id);
	}
	
	// Create = C 
	//@PostMapping("/user/{id}")
	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public ResponseEntity<Object> createUser(@RequestBody Users user){
		Users saveUser = userRepository.save(user) ;
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	} 
	
	//Update = U 
	//@PutMapping("/users/{id}")
	@RequestMapping(method = RequestMethod.PUT , value="/users/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody Users user,@PathVariable Long id){
		Optional<Users> userOptional = userRepository.findById(id);
		if(!userOptional.isPresent())
			return ResponseEntity.notFound().build();
		user.setId(id);
		userRepository.save(user);
		return ResponseEntity.noContent().build();
	}
}
