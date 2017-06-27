package com.gmail.pages;

import javax.swing.Box.Filler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.folloze.pages.BasePage;

public class GmailLogin extends BasePage{

	WebDriver driver;
	WebDriverWait wait;
	
	public GmailLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	public void SignInGmailAccount(String username, String password){
		try{
			WebElement uName = driver.findElement(By.xpath(".//*[@id='identifierId']"));
			fill(uName, username);
			WebElement nextBtn = driver.findElement(By.id("identifierNext"));
			click(nextBtn);
		}catch (Exception e){
			System.out.println("Something went wrong");
		}
	}
	
	
}
