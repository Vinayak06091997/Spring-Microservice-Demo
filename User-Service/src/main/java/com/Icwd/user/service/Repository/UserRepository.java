package com.Icwd.user.service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Icwd.user.service.Entities.User;

public interface UserRepository extends JpaRepository<User, String> 
{

	
}
