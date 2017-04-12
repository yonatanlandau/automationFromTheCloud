package com.folloze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.folloze.data.ObjectMap;


public class Login extends BasePage{

	WebDriver driver;
	WebDriverWait wait;
	

	public Login(WebDriver driver) {
		this.driver = driver;
	}
	
	public void signInEmail(String accountEmail,  String Accountpsw) throws Exception{
		ObjectMap objMap = new ObjectMap("objectmap.properties");
		WebElement mail = driver.findElement(objMap.getLocator("folloze.homepage.email"));
		fill(mail, accountEmail);
		WebElement password = driver.findElement(objMap.getLocator("folloze.homepage.password"));
		fill(password, Accountpsw);
		WebElement signin = driver.findElement(objMap.getLocator("folloze.homepage.signin"));
		click(signin);
		ExplicitWaitText(driver, "Create Board");
	}
	
	
	public void signInLinkedIn() throws Exception{
		String winHandleBefore = driver.getWindowHandle();
		click(driver.findElement(By.className("react-Login-components-LinkedInAuthButton-___styles__buttonContainer___1NE_m")));
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		LinkedInLogIn linkSingIn = new LinkedInLogIn(driver);
		linkSingIn.linkedInAccess();
		driver.switchTo().window(winHandleBefore);
	}
	
	public void signUp(){
		WebElement signUpLink = driver.findElement(By.linkText("Sign Up"));
		click(signUpLink);
	}
	
}
