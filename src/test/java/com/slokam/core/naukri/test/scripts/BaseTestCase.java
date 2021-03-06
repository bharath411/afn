package com.slokam.core.naukri.test.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.slokam.core.naukri.test.commons.dataHandlers.PropertiesReader;

public class BaseTestCase {

	public WebDriver driver = null;
	public PropertiesReader props = new PropertiesReader();
	public String url = "";
	public String browser ="";
	public long waitTime = 0;
	/**
	 * TODO -1. Read url from properties file. 2. Read timeout from properites
	 * file. 3. Update hard coded paths of binary files. 4. Browser should be in
	 * properties files
	 */
	@BeforeMethod
	public void launchBrowser() {
		browser = props.getProp("browser");
		url = props.getProp("url");
		String time = props.getProp("waitTime");
		waitTime = Long.parseLong(time);
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
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
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
