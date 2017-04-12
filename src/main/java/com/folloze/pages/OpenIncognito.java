package com.folloze.pages;

import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OpenIncognito extends BasePage{

	WebDriver driver2;
	String mail;
	Yopmail yopM;
	YopmailNet yopMnet;
	CreateAccount createAcc;
	WebDriverWait wait;

	
	public OpenIncognito(WebDriver driver) {
		this.driver2 = driver;
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver2 = new ChromeDriver(capabilities);
	}
	
	public void goToYopmailGetRandomMail(){
		yopM = new Yopmail(driver2);
		yopM.goToyopmailNewMail();
		yopM.randomEmailAddress();
		mail = yopM.getMail();
		
	}
	
	public void goToYopmailNetGetRanomMail(){
		yopMnet = new YopmailNet(driver2);
		yopMnet.goToyopmailNetNewMail();
		yopMnet.randomEmailAddress();
		mail = yopMnet.getMail();
	}
	
	public void clickConfirmMail() throws InterruptedException{
		yopMnet = new YopmailNet(driver2);
		yopMnet.goToyopmailNetNewMail();
		yopMnet.submit();
		yopMnet.refresh();
		yopMnet.clickOnLink();
		Assert.assertEquals(yopMnet.isOnboarding(), true);
	}
	
	public void follozeHome() throws AWTException, InterruptedException{
		CreateAccount newAccount = new CreateAccount(driver2);
		newAccount.goToFollozeHome();
	}
	
	public void signUpYes(){
		CreateAccount newAccount = new CreateAccount(driver2);
		NewAccountSuccess newAccountSuc = new NewAccountSuccess(driver2);
		newAccount.signUp();
		newAccount.enterWorkMail(mail);
		newAccount.next();
		newAccount.isMicrosoftSalesYes();
		newAccount.fillAlias();
		newAccount.submit();
		newAccountSuc.blockedYes();
	}
	
	public void signUpNO(){
		CreateAccount newAccount = new CreateAccount(driver2);
		NewAccountSuccess newAccountSuc = new NewAccountSuccess(driver2);
		newAccount.signUp();
		newAccount.enterWorkMail(mail);
		newAccount.next();
		newAccount.isMicrosoftSalesNO();
		newAccount.firstName();
		newAccount.lastName();
		newAccount.fillAlias();
		newAccount.submit();
		newAccountSuc.blockedNo();
	}
	
	public void signUpRegularLinkedIn() throws InterruptedException{
		CreateAccount newAccount = new CreateAccount(driver2);
		NewAccountSuccess newAccountSuc = new NewAccountSuccess(driver2);
		newAccount.signUp();
		newAccount.enterWorkMail(mail);
		newAccount.next();;
		newAccount.clickSignInLinkedIn();
		newAccountSuc.notBlockedOrg();
	}
	
	public void signUpRegularEmail(){
		CreateAccount newAccount = new CreateAccount(driver2);
		NewAccountSuccess newAccountSuc = new NewAccountSuccess(driver2);
		newAccount.signUp();
		newAccount.enterWorkMail(mail);
		newAccount.next();
		newAccount.isCreateAccountBtn();
		newAccount.firstName();
		newAccount.lastName();
		newAccount.enterPassword();
		newAccount.checkTou();
		newAccount.submit();
		newAccountSuc.notBlockedOrg();
	}
	
	public String getMailFromIncognito(){
		return mail;
	}
	
	public void YopmRefesh(){
		yopM.refresh();
		yopM.refresh();
		yopM.refresh();
	}
	
	public void clickOnYopMailLink(){
		yopM.clickOnLink();
	}
	
	public void createAccountmail(){
		CreateAccount newAccount = new CreateAccount(driver2);
		NewAccountSuccess newAccountSuc = new NewAccountSuccess(driver2);
		newAccount.checkTou();
		newAccount.enterPassword();
		newAccount.createAccount();
		newAccountSuc.fromInvite();
	}
	
	
	public void createAccountLinkedIn() {
		CreateAccount newAccount = new CreateAccount(driver2);
		NewAccountSuccess newAccountSuc = new NewAccountSuccess(driver2);
		newAccount.clickSignInLinkedIn();
		newAccountSuc.fromInvite();
	}
	
	public void unSingLinkedin() throws AWTException, InterruptedException{
		CreateAccount newAccount = new CreateAccount(driver2);
		newAccount.goUnSign();
	}
	
	public void quit(){
		driver2.quit();
	}
	
	
}
