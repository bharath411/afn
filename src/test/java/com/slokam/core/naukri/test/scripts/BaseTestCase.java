package com.slokam.core.naukri.test.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

public class BaseTestCase {

	public WebDriver driver = null;

	/**
	 * TODO -1. Read url from properties file. 2. Read timeout from properites
	 * file. 3. Update hard coded paths of binary files. 4. Browser should be in
	 * properties files
	 */
	@BeforeSuite
	public void launchBrowser() {
		String browser = "chrome";
		/*if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\jars\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\jars\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "D:\\jars\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}*/

		switch (browser) {
				case "chrome":
					System.setProperty("webdriver.chrome.driver", "D:\\jars\\chromedriver.exe");
					driver = new ChromeDriver();
				break;
				case "firefox":
					System.setProperty("webdriver.gecko.driver", "D:\\jars\\geckodriver.exe");
					driver = new FirefoxDriver();
					break;
				case "ie":
					System.setProperty("webdriver.ie.driver", "D:\\jars\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
					break;
				case "safari":
					//System.setProperty("webdriver.ie.driver", "D:\\jars\\IEDriverServer.exe");
					driver = new SafariDriver();
					break;
				default:
					Assert.fail("No matching browser exists.");
				break;
		}

		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().window().maximize();

	}
	
	
	public void sleep(int time){
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean isElementPresent(By by){
		
		boolean flag = true;
		if(driver.findElements(by).size()==0){
			flag = false;
		}
		return flag;
	}
}
