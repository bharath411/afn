package com.slokam.testng.examples;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(value=ListenerImpl.class)
public class ProgramTest {

	//Listeners 
	/*	Events --> started
					completed
						passed
						failed
						skipped
						
					suite started
						completed.*/
	
	@Test
	public void test2(){
		System.out.println("I am test2");
	}
	
	@Test
	public void test3(){
		System.out.println("I am test3");
		Assert.fail();
	}
}
