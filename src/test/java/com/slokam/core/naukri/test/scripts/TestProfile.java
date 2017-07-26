package com.slokam.core.naukri.test.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestProfile extends BaseTestCase {

	/**
	 * read username , password from properties file.
	 */
	String username = "";
	String password = "";

	@BeforeMethod
	public void loginToNaukri() {
		driver.get("https://www.naukri.com/");
		/*
		 * if(isElementPresent(By.xpath("//div[text()='My Naukri']"))){
		 * //logout(); }
		 */
		username = props.getProp("username");
		password = props.getProp("password");
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
		//System.out.println("I am in verifyProfileDelete");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("title")).sendKeys("hi ");
		WebElement ele=driver.findElement(By.id("cityId"));
		Select select = new Select(ele);
		select.selectByVisibleText("Hyderabad / Secunderabad");
		
		WebElement ee= driver.findElement(By.id("experienceYear"));
		Select selects = new Select(ee);
		selects.selectByVisibleText("Fresher");
		
		//WebElement eee=driver.findElement(By.xpath("//optgroup[@class='optGrp']"));
		//Select se = new Select(eee);
		//se.selectByVisibleText("Hyderabad");
		
		
		WebElement e=driver.findElement(By.id("industryTypeId"));
		Select ss = new Select(e);
		ss.selectByVisibleText("Accounting/Finance");		
		
		WebElement eeee=driver.findElement(By.id("funcAreaId"));
		Select ses = new Select(eeee);
		ses.selectByVisibleText("Analytics & Business Intelligence");
		
		
		WebElement eees=driver.findElement(By.id("roleId"));
		Select seee = new Select(eees);
		seee.selectByVisibleText("Project Architect");
		
		driver.findElement(By.xpath("//button[@value='Save Changes']")).click();
		
		
		
		String s=driver.findElement(By.id("confirmMessage")).getText();
		System.out.println(s);
		
		
		
	}

	@Test
	public void verifyUpdateProfile() {
		System.out.println("I am verifying Verify update profile");
		driver.findElement(By.xpath("//*[@id='compDetail']//b[text()='View and Update Profile']")).click();
		driver.findElement(By.xpath("//*[@id='rPanel']/div/h2[1]/a[text()='Edit']")).click();
		driver.findElement(By.xpath("//*[@id='summary']")).sendKeys("Testing for update the profile");
		driver.findElement(By.xpath("//*[@id='editForm']/div[2]/div/button")).click();
		String message=driver.findElement(By.xpath("//*[@id='confirmMessage']")).getText();
		System.out.println("The message ="+message);
	}

	@Test
	public void verifyProfileSummary() {
		System.out.println("I am in verifyCreateProfile");
	}
}
