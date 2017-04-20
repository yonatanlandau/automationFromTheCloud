package com.folloze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;




public class Login extends BasePage{

	WebDriver driver;
	WebDriverWait wait;
	

	public Login(WebDriver driver) {
		this.driver = driver;
	}
	
	public void signInEmail(String accountEmail,  String Accountpsw) throws Exception{
		WebElement mail = driver.findElement(By.cssSelector("input[name='user[email]']"));
		fill(mail, accountEmail);
		WebElement password = driver.findElement(By.cssSelector("input[name='user[password]']"));
		fill(password, Accountpsw);
		WebElement signin = driver.findElement(By.cssSelector("button"));
		click(signin);
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
