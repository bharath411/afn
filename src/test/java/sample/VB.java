package sample;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class VB {


	@BeforeClass
	public void beforeClass(){
		System.out.println("I am in a of beforeClass of VB");
	}
	
	@AfterClass
	public void afterClass(){
		System.out.println("I am in a of afterClass of VB ");
	}
	
	@Test
	public void a() {
		System.out.println("I am in a of VBA");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("Before method ofVBA");
	}
	@Test
	public void ab() {
		System.out.println("I am in b ofVBA");
	}
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("I am in after Method of VBA");
	}
	@Test
	public void ac() {
		System.out.println("I am in c of AVB");
	}
	
	
	@Test
	public void ad() {
		System.out.println("I am in ad of AVB");
	}
}
