package com.folloze.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.folloze.pages.CompanyAdmin;
import com.folloze.pages.Login;
import com.folloze.pages.Onboarding;


public class NewTest {

	private WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "C:/Users/FollozePC/projects/TestsInCloud/src/test/resources/chromedriver2.exe");
		driver = new ChromeDriver();
		driver.get("http://app.folloze.com");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@Test (priority=1)
	public void LinkedInSignUpWithInvitation() throws Exception {

		Login log1 = new Login(driver);
		CompanyAdmin coAd = new CompanyAdmin(driver);
		Onboarding onB1 = new Onboarding(driver);
		log1.signInEmail("admino123@yopmail.com", "qwer1234");
		
	}
	
	
		
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
