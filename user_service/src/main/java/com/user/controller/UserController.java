package com.user.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.model.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) {
		
		User user = userService.getUser(id);
		List contact = this.restTemplate.getForObject("http://contact-service/contacts/users/"+user.getUserId(),List.class);
		user.setContacts(contact);
		return user;
	}
	
	
	
	
}
