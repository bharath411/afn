package com.slokam.testng.examples;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginTest {

	/*@Test
	@Parameters(value={"user","pass"})
	public void verifyLogin(String username,String password){
		System.out.println("Login Test");
		System.out.println(username);
		System.out.println(password);
	}*/
	@Test
	@Parameters(value={"browser"})
	public void launchTest(@Optional("chrome") String browser){
		
		System.out.println(browser);
		
	}
}
