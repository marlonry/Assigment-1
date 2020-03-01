package controller;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
/**
 * <p>This is the login Controller</p>
 * @author Marlon
 */
public class LoginController {
	// File String 
	private String username;
	private String password;
	
	/**
	 * <p>Login Controller Class Constructor</p>
	 * @author Marlon
	 */
	public LoginController() {
		this.username = "marlon";
		this.password = "marlon";
	}
	
	/**
	 * <p>Gets Username Attribute</p>
	 * @author Marlon
	 * @param none
	 * @return String
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * <p>Gets Password Attribute</p>
	 * @author Marlon
	 * @return String
	 */
	public String getPassword() {
		return password;
	}
}
