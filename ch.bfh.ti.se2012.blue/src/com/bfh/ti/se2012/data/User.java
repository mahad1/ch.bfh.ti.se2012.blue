/**
 * The class User is a Model Class 
 * @version 1.0
 * @author Team Blue
 *
 */
package com.bfh.ti.se2012.data;

/*
 * Simple User ID class.
 */
public class User {

	private String firstname;
	private String lastname;
	
	public User(String first, String last){
		firstname = first;
		lastname = last;
	}
	
	public String getFirstName(){
		return firstname;
	}
	
	public String getLastName(){
		return lastname;
	}
}
