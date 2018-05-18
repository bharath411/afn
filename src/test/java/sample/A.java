package sample;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class A {

	
	@BeforeClass
	public void beforeClass(){
		System.out.println("I am in a of beforeClass of A");
	}
	
	@AfterClass
	public void afterClass(){
		System.out.println("I am in a of afterClass of A ");
	}
	
	@Test
	public void a() {
		System.out.println("I am in a of A");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("Before method of A");
	}
	@Test
	public void ab() {
		System.out.println("I am in b of A");
	}
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("I am in after Method of A");
	}
	@Test
	public void ac() {
		System.out.println("I am in c of A");
	}
	@BeforeSuite
	public void absda(){
		System.out.println("I am in a of BeforeSuite of A");
	}
	
	@AfterSuite
	public void afterSuite(){
		System.out.println("I am in  AfterSuite of A ");
	}
	
	@Test
	public void ad() {
		System.out.println("I am in ad of A");
	}
}
