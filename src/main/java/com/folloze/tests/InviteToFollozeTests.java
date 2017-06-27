package com.folloze.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.folloze.utils.Utils;
import com.gmail.pages.GmailLogin;

public class InviteToFollozeTests {

	private WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver = Utils.getDriver("http://gmail.com");
	}
	
	@Test
	public void signInToGmail(){
		GmailLogin gmailLogin = new GmailLogin(driver);
		gmailLogin.SignInGmailAccount("admin@follozeqa.com", "xxx");
	}
	
	
	
	
}
