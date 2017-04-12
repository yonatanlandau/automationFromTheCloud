package com.folloze.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Yopmail extends BasePage{

	WebDriver driver2;
	String mail;

	public Yopmail(WebDriver driver) {
		this.driver2 = driver;
	}

	public void goToyopmailNewMail(){
		driver2.get("http://www.yopmail.com");
	}

	public void randomEmailAddress(){
		WebElement link =driver2.findElement(By.cssSelector("a[href='email-generator.php']"));
		click(link);
		String emailAdd = driver2.findElement(By.cssSelector("input[name='login']")).getAttribute("value");
		mail = emailAdd;
		WebElement checkMails = driver2.findElement(By.cssSelector("input[value='Check mails']"));
		click(checkMails);
	}

	public String getMail(){
		return mail;
	}

	public void refresh(){
		driver2.navigate().refresh();
	}

	public void clickOnLink(){
		driver2.switchTo().frame(driver2.findElement(By.id("ifmail")));
		WebElement linkToFollozeSignUp = driver2.findElement(By.linkText("accept this invitation and 'get rollin'"));
		ExplicitWaitClick(driver2, linkToFollozeSignUp);
		String  winHandleMain = driver2.getWindowHandle();
		click(linkToFollozeSignUp);
		for(String winHandle : driver2.getWindowHandles()){
			driver2.switchTo().window(winHandle);
		}
	}

	
	public String isCreateAnAccount(){
		String pageTitle =  driver2.findElement(By.cssSelector(".react-Login-components-CreateAccount-___styles__title___17Vk2.react-Login-sharedStyles-___styles__title___75Vxn")).getText();
		return pageTitle;
	}
	
	public void createAccountLinkedIn() throws Exception{
		CreateAccount createAcc = new CreateAccount(driver2);
		createAcc.isHardcodedMail(mail);
		createAcc.checkTou();
		LinkedInLogIn linkedIn = new LinkedInLogIn(driver2);
		WebElement linkedin = driver2.findElement(By.cssSelector(".react-Login-components-LinkedInAuthButton-___styles__text___1ipAP"));
		String  winHandleMain = driver2.getWindowHandle();
		click(linkedin);
		for(String winHandle : driver2.getWindowHandles()){
			driver2.switchTo().window(winHandle);
		}
		linkedIn.linkedInAccess();
		driver2.switchTo().window(winHandleMain);
	}
	
	public boolean isOnboarding() throws InterruptedException{
		boolean isOnb = true;
		sleep();
		String onboardingURL = driver2.getCurrentUrl();
		System.out.println(onboardingURL);
		if(onboardingURL.equals("https://app.folloze.com/app/home/mine")){
			isOnb = true;
		}else{
			isOnb=false;
		}
		sleep();
		return isOnb;
	}
	
	public void quit() throws InterruptedException{
		sleep();
		driver2.quit();
	}
	
}
