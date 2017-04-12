package com.folloze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YopmailNet extends BasePage{
	

	WebDriver driver2;
	String mail;

	public YopmailNet(WebDriver driver) {
		this.driver2 = driver;
	}

	public void goToyopmailNetNewMail(){
		driver2.get("http://www.yopmail.net");
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
		driver2.navigate().refresh();
		driver2.navigate().refresh();
	}

	public void clickOnLink() throws InterruptedException{
		sleep();
		driver2.switchTo().frame(driver2.findElement(By.id("ifmail")));
		WebElement linkToFollozeSignUp = driver2.findElement(By.linkText("Confirm my account"));
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
		String onboardingURL = driver2.getCurrentUrl();
		if(onboardingURL.equals("https://app.folloze.com/app/home/mine")){
			isOnb = true;
		}else{
			isOnb=false;
		}
		return isOnb;
	}
	
	public void submit(){
		WebElement submint = driver2.findElement(By.cssSelector("input[type='submit']"));
		click(submint);
	}
	
	public void quit() throws InterruptedException{
		sleep();
		driver2.quit();
	}
	

}
