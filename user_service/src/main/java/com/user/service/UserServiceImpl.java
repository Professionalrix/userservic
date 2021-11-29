package com.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.model.User;

@Service
public class UserServiceImpl implements UserService {

	 List<User> list = List.of(new User(1311L,"Ankit Singh","323232323"),new User(1312L,"Ankitd Sidfngh","323232323"),
			new User(1313L,"Ankit Singh","323232323")
			);
	
	
	@Override
	public User getUser(Long id) {
		
		return list.stream().filter(user->user.getUserId().equals(id)).findAny().orElse(null);
	} 

}
