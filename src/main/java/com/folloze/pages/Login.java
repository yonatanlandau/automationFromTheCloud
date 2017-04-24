package com.folloze.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends BasePage{

	WebDriver driver;
	WebDriverWait wait;
	

	public Login(WebDriver driver) {
		this.driver = driver;
	}
	
	public void signInEmail(String accountEmail,  String Accountpsw) throws Exception{
		try{
			WebElement mail = driver.findElement(By.cssSelector("input[name='user[email]']"));
			fill(mail, accountEmail);
			WebElement password = driver.findElement(By.cssSelector("input[name='user[password]']"));
			fill(password, Accountpsw);
			WebElement signin = driver.findElement(By.cssSelector("button"));
			click(signin);
		}catch (Exception e){
			System.out.println("Something went wrong");
		}
		
	}
	
	public void signUp(){
		WebElement signUpLink = driver.findElement(By.linkText("Sign Up"));
		click(signUpLink);
	}
	
}
