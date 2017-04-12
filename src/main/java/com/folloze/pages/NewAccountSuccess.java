package com.folloze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccountSuccess extends BasePage{

	WebDriver driver;
	WebDriverWait wait;
	
	public NewAccountSuccess(WebDriver driver) {
		this.driver = driver;
	}
	
	public void fromInvite(){
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.urlToBe("https://app.folloze.com/app/home/mine"));
	}
	
	public void notBlockedOrg(){
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.urlContains("app.folloze.com/signup/success"));
	}
	
	public void blockedYes(){
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.urlContains("msft.sts.microsoft.com"));
	}
	
	public void blockedNo(){
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.urlContains("app.folloze.com/signup/microsoft/success"));
	}
	
	
}
