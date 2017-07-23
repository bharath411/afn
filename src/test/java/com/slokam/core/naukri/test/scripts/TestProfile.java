package com.slokam.core.naukri.test.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestProfile extends BaseTestCase {

	/**
	 * read username , password from properties file.
	 */
	String username = "bharath.selenium26@gmail.com";
	String password = "selenium123";

	@BeforeMethod
	public void loginToNaukri() {
		driver.get("https://www.naukri.com/");
		/*
		 * if(isElementPresent(By.xpath("//div[text()='My Naukri']"))){
		 * //logout(); }
		 */
		login(username, password);
	}

	@AfterMethod
	public void afterMethod() {
		// logout();
	}

	public void login(String username, String password) {
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		sleep(5);
		driver.findElement(By.id("eLogin")).sendKeys(username);
		driver.findElement(By.id("pLogin")).sendKeys(password);
		driver.findElement(By.xpath("//button[@value='Login']")).click();
	}

	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[text()='My Naukri']"))).build().perform();
		sleep(2);
		driver.findElement(By.xpath("//a[@title='Log Out']")).click();
	}

	@Test
	public void verifyProfileProjects() {
		System.out.println("I am in verifyProfileDelete");
	}

	@Test
	public void verifyUpdateProfile() {
		System.out.println("I am in verifyUpdateProfile");
	}

	@Test
	public void verifyProfileSummary() {
		System.out.println("I am in verifyCreateProfile");
	}
}
