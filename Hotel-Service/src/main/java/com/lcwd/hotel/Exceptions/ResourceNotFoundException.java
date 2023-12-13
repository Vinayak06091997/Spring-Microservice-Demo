package com.lcwd.hotel.Exceptions;


public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String string) {
		super(string);
	}

	public ResourceNotFoundException()
	{
		super("Resource Not Found");
	}
	
	
}
