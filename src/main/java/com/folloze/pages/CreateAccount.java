package com.folloze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount extends BasePage{

	WebDriver driver;
	WebDriverWait wait;

	public CreateAccount(WebDriver driver2) {
		this.driver = driver2;
	}

	public void goToFollozeHome(){
		driver.get("http://app.folloze.com");
	}

	public void goUnSign(){
		driver.get("http://app.folloze.com/linkedin/unsign");
	}

	public boolean isHardcodedMail(String mail){
		boolean hardcodedMail = true;
		String userMailAdd = driver.findElement(By.cssSelector(".react-Login-components-Signup-___styles__emailInput___3xaXT.react-Login-sharedStyles-___styles__emailInput___BApS9")).getText();
		if (mail.equals(userMailAdd)){
			hardcodedMail = true;
		}else {
			hardcodedMail = false;
		}
		return hardcodedMail;
	}

	public void isCreateAccountBtn(){
		wait = new WebDriverWait(driver, 30);
		WebElement createAccount = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Terms of Use")));
	}

	public void checkTou(){
		wait = new WebDriverWait(driver, 30);
		WebElement tou = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='checkbox']")));
		click(tou);
	}

	public void enterPassword(){
		WebElement pswd = driver.findElement(By.cssSelector("input[type='password']"));
		fill(pswd, "qwer1234");
	}

	public void createAccount(){
		WebElement createA = driver.findElement(By.cssSelector("button"));
		click(createA);
	}

	public void clickSignInLinkedIn(){
		CreateAccount createAcc = new CreateAccount(driver);
		createAcc.checkTou();
		LinkedInLogIn linkedIn = new LinkedInLogIn(driver);
		linkedIn.openLinkedInAPI();
		linkedIn.isErrorMessage();
	}



	public void enterWorkMail(String mailAddress){
		WebElement workEmailInput = driver.findElement(By.cssSelector("input[placeholder='Work Email']"));
		fill(workEmailInput, mailAddress);
	}

	public void next(){
		WebElement nextBtn =  driver.findElement(By.tagName("button"));
		click(nextBtn);
	}

	public void isMicrosoftSalesYes(){
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.urlToBe("http://app.folloze.com/signup/microsoft"));
		WebElement yes = driver.findElement(By.cssSelector("div>button:nth-child(1)"));
		click(yes);
	}

	public void isMicrosoftSalesNO(){
		wait = new WebDriverWait(driver, 30);
		WebElement no = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div>button:nth-child(2)")));
		click(no);
	}

	public void firstName(){
		WebElement fn = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
		fill(fn, "testBuddy2");
		fill(fn, "testBuddy2");
		fill(fn, "testBuddy2");
	}

	public void lastName(){
		WebElement fn = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
		fill(fn, "testBuddy2");
	}

	public void fillAlias(){
		wait = new WebDriverWait(driver, 30);	
		WebElement aliasMail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Microsoft Alias']")));
		fill(aliasMail, "QAtest_alias@yopmailtest.com");
	}

	public void submit(){
		WebElement submit = driver.findElement(By.cssSelector("form>div>button"));
		click(submit);
	}

	public void signUp(){
		WebElement signUp = driver.findElement(By.linkText("Sign Up"));
		click(signUp);
	}
}
