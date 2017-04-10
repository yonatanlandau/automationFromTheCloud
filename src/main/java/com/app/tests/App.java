package com.app.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class App {

	WebDriver driver;

	@Test
	public void test(){
		try{

			System.setProperty("webdriver.chrome.driver", "C:/Users/FollozePC/projects/TestsInCloud/src/test/resources/chromedriver2.exe");
			driver = new ChromeDriver();
			driver.get("http://app.folloze.com");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}catch (Exception e){
			System.out.println("URL not found");
		}

	}



}
