package com.folloze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.folloze.data.ObjectMap;

public class LinkedInLogIn extends BasePage{

	WebDriver driver;
	WebDriverWait wait;

	public LinkedInLogIn(WebDriver driver) {
		this.driver = driver;
	}
	
	public void linkedInAccess(){
		wait = new WebDriverWait(driver, 30);	
		WebElement access = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".allow.btn-primary"))));
		WebElement mail = driver.findElement(By.id("session_key-oauth2SAuthorizeForm"));
		fill(mail, "yoni.landau@gmail.com");
		WebElement password = driver.findElement(By.id("session_password-oauth2SAuthorizeForm"));
		fill(password, "Philipsdell2016");
		click(access);
	}
	
	public void openLinkedInAPI(){
		LinkedInLogIn linkedIn = new LinkedInLogIn(driver);
		wait = new WebDriverWait(driver, 1500);
		WebElement linkedin = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".react-Login-components-LinkedInAuthButton-___styles__text___1ipAP")));
		//WebElement linkedin = driver.findElement(By.cssSelector(".react-Login-components-LinkedInAuthButton-___styles__text___1ipAP"));
		String  winHandleMain = driver.getWindowHandle();
		click(linkedin);
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		linkedIn.linkedInAccess();
		driver.switchTo().window(winHandleMain);
	}
	
	public void isErrorMessage(){
		String url = driver.getCurrentUrl();
		if(!url.contains("http://app.folloze.com/signup/success")){
			LinkedInLogIn linkedIn = new LinkedInLogIn(driver);
			linkedIn.openLinkedInAPI();
		}
	}
	
}
