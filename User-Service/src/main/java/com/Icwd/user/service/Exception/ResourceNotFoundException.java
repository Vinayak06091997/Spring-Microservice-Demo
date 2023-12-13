package com.Icwd.user.service.Exception;

public class ResourceNotFoundException extends RuntimeException{

	
	public ResourceNotFoundException()
	{
		super("Resource Not Found Server  !!");
	}
	
	public ResourceNotFoundException(String message)
	{
		super(message);
	}
}
