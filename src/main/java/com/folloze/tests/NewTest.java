package com.folloze.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.folloze.data.ObjectMap;
import com.folloze.pages.BoardPage;
import com.folloze.pages.CompanyAdmin;
import com.folloze.pages.CreateAccount;
import com.folloze.pages.Login;
import com.folloze.pages.Onboarding;
import com.folloze.pages.OpenIncognito;
import com.folloze.pages.Yopmail;

public class NewTest {

	private WebDriver driver;
	Logger logger;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "C:/Users/FollozePC/projects/automation-test/src/main/resources/chromedriver.exe");
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
		onB1.companyAdmin("yopAdmin");
		coAd.navMenuTeams();
		OpenIncognito incog = new OpenIncognito(driver);
		incog.goToYopmailGetRandomMail();	
		coAd.typeEmailinUM(incog.getMailFromIncognito());
		coAd.inviteToTeam();	
		incog.YopmRefesh();	
		incog.clickOnYopMailLink();	
		incog.createAccountLinkedIn();	
		incog.unSingLinkedin();	
		incog.quit();
	}
	
	@Test (priority=2)
	public void EmailSignUpWithInvitation() throws Exception {

		CompanyAdmin coAd = new CompanyAdmin(driver);
		Onboarding onB1 = new Onboarding(driver);
		OpenIncognito incog = new OpenIncognito(driver);
		incog.goToYopmailGetRandomMail();	
		coAd.typeEmailinUM(incog.getMailFromIncognito());
		coAd.inviteToTeam();
		incog.YopmRefesh();	
		incog.clickOnYopMailLink();
		incog.createAccountmail();
		incog.quit();
		onB1.signOut();
		
	}
	
	
	@Test (priority = 3)
	public void SignUpMSflowYes() throws AWTException, InterruptedException{
		
		OpenIncognito incog = new OpenIncognito(driver);
		incog.goToYopmailGetRandomMail();
		incog.follozeHome();
		incog.signUpYes();
		incog.quit();
		
	}
	
	
	@Test (priority = 4)
	public void SignUpMSflowNO() throws AWTException, InterruptedException{

		OpenIncognito incog = new OpenIncognito(driver);
		incog.goToYopmailGetRandomMail();
		incog.follozeHome();
		incog.signUpNO();
		incog.quit();

	}
	
	
	@Test (priority = 5)
	public void SignUpregularLinkedIn() throws Exception{	
		
		OpenIncognito incog = new OpenIncognito(driver);
		incog.goToYopmailNetGetRanomMail();
		incog.follozeHome();
		incog.signUpRegularLinkedIn();
		incog.clickConfirmMail();
		incog.unSingLinkedin();
		incog.quit();
		
	}
	
	
	@Test (priority = 6)
	public void SignUpregularEmail() throws Exception{	
		
		OpenIncognito incog = new OpenIncognito(driver);
		incog.goToYopmailNetGetRanomMail();
		incog.follozeHome();
		incog.signUpRegularEmail();
		incog.clickConfirmMail();
		incog.quit();
		
	}
	
		
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
