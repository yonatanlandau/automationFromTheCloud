package com.folloze.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	String  winHandleMain;


	public void click(WebElement el){
		el.click();
	}

	public void fill(WebElement el, String data){
		el.clear();
		el.sendKeys(data);
	}


	public  void ExplicitWaitText(WebDriver driver, String text){
		(new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(By.partialLinkText(text)));		
	}

	public void ExplicitWaitClick(WebDriver driver, WebElement el){
		(new WebDriverWait(driver,15)).until(ExpectedConditions.elementToBeClickable(el));
	}

	public void hover(WebElement el){
		action = new Actions(driver);
		action.moveToElement(el).perform();
	}

	public void isClickable(WebElement el){
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(el));

	}

	public void isPresent(WebElement el){
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(el));
	}

	public void follozeLogo(){
		try{
			WebElement logo = driver.findElement(By.cssSelector(".header-button.home-button-container"));
			click(logo);
		}catch(Exception e){
			System.out.println("Something went wrong");
		}

	}

	public void sleep() throws InterruptedException{
		Thread.sleep(5000);
	}

}
