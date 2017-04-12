package com.folloze.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Onboarding extends BasePage{

	WebDriver driver;
	WebDriverWait wait;
	
	public Onboarding(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void signOut(){
		ExplicitWaitText(driver, "yopAdmin");
		click(driver.findElement(By.cssSelector(".user-link.ng-binding")));
		click(driver.findElement(By.cssSelector(".header-add-dropdown.ng-scope>a:nth-child(6)")));
	}
	
	public void companyAdmin(String user){
		wait = new WebDriverWait(driver, 15000);
		WebElement userName = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(user)));
		click(userName);
		wait = new WebDriverWait(driver, 15000);
		WebElement companyAdminLink = driver.findElement(By.cssSelector("a[ui-sref='organization']"));
		click(companyAdminLink);
	}
	
	public String companyAdminAssert() throws InterruptedException{
		sleep();
		String pageTitle = driver.findElement(By.cssSelector(".has-subtitle.ng-scope")).getText();
		String strOut = pageTitle.substring(0,22);
		System.out.println("Got to " +  strOut + " Page");
		return strOut;
	}
	
	public void createNewBoard(){
		driver.findElement(By.linkText("Create Board")).click();
		ExplicitWaitText(driver, "Add");
		fill(driver.findElement(By.cssSelector(".title>input.text")), "NewAutoBoard");
		fill(driver.findElement(By.cssSelector("textarea[placeholder='Why is this important?']")), "This is description");
		fill(driver.findElement(By.cssSelector("div[template='tagsListTemplate']>.inline-selector-input-container>input[class='inline-selector-input']")), "l");
		List <WebElement> options = driver.findElements(By.cssSelector(".autocomplete-results>.ng-scope>.ng-binding"));
		for(WebElement opt: options){
			String value = opt.getText();
			if(value.equals("#leadboard")){
				click(opt);
				break;
			}
		}
		ExplicitWaitText(driver, "Find more images");
		click(driver.findElement(By.cssSelector("a[ng-click='done()']")));
		ExplicitWaitText(driver, "Content");
	}
	
	
}
