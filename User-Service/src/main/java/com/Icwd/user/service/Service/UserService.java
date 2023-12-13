package com.Icwd.user.service.Service;

import java.util.List;

import com.Icwd.user.service.Entities.User;

public interface UserService {
	
	//user opartion
	
	public User saveUser(User user);
	
	public List<User> getAllUser();
	
	public User getUserById(String userId);
	
	public User updateUser(User user);
	
	public User deleteUser(String userId);

}
