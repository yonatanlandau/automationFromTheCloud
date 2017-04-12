package com.folloze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompanyAdmin extends BasePage{
	
	WebDriver driver;
	WebDriverWait wait;

	public CompanyAdmin(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navMenuTeams(){
		wait = new WebDriverWait(driver, 15000);
		WebElement teams = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Teams")));
		click(teams);
	}
	
	public void typeEmailinUM(String mail){
		WebElement emailInputField = driver.findElement(By.cssSelector("input[placeholder='Email Address']"));
		fill(emailInputField, mail);
		for (int i =0; i<=10; i++){
			emailInputField.sendKeys(Keys.BACK_SPACE);
		}
		WebElement firstName = driver.findElement(By.cssSelector("input[placeholder='First Name (optional)']"));
		WebElement lastName = driver.findElement(By.cssSelector("input[placeholder='Last Name (optional)']"));
		fill(firstName, "asfd");
		fill(lastName, "xcb");
	}
	
	public void inviteToTeam(){ 
		wait = new WebDriverWait(driver, 30);
		Boolean inviteBtn2 = wait.until(ExpectedConditions.attributeToBe(By.cssSelector(".btn.btn-big.btn-notice"), "class", "btn btn-big btn-notice"));
		if(inviteBtn2 == true){
			WebElement inviteBtn21 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-big.btn-notice")));
			click(inviteBtn21);
		}
	}
	
}
