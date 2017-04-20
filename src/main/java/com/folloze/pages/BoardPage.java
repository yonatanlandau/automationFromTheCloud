package com.folloze.pages;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BoardPage extends BasePage{

	WebDriver driver;

	public BoardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void backToMyContent() throws InterruptedException{
		sleep();
		driver.navigate().back();
		sleep();
	}
	
	public void openFirstBoard(){
		ExplicitWaitText(driver, "Yonatan");
		ExplicitWaitText(driver, "Smile");
		driver.findElement(By.xpath(".//*[@id='ng-app']/body/div[1]/div[1]/div/div[2]/div/div/ul/li[1]/prism/div/div/div[2]/div[1]/a/h3")).click();
		}

	public void addLinkItem() {
		click(driver.findElement(By.cssSelector(".add-content-bar>:nth-child(1)")));
		click(driver.findElement(By.cssSelector(".add-content-bar>.content-btn.first")));
		fill(driver.findElement(By.cssSelector("input[type='url']")), "http://www.ynet.co.il");
		ExplicitWaitText(driver, "Find more images");
		click(driver.findElement(By.cssSelector("a[ng-show='doneText']")));
	}
	
	public void file() throws IOException{
		ExplicitWaitText(driver, "Add Content");
		click(driver.findElement(By.cssSelector(".add-content-bar>:nth-child(1)")));
		click(driver.findElement(By.cssSelector(".add-content-bar>.content-btn.second")));
		click(driver.findElement(By.cssSelector("input.file")));
		Runtime.getRuntime().exec("C:/Users/FollozePC/projects/automation-test/src/main/resources/test_chrome.exe");
		
	}
	
	public void boxFile() throws InterruptedException{
		ExplicitWaitText(driver, "Add Content");
		click(driver.findElement(By.cssSelector(".add-content-bar>:nth-child(1)")));
		click(driver.findElement(By.cssSelector(".add-content-bar>.content-btn.third")));
		ExplicitWaitClick(driver, driver.findElement(By.id("box-select")));
		click(driver.findElement(By.id("box-select")));
		
		String  winHandleMain = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		
		fill(driver.findElement(By.cssSelector("input[name='login']")), "yonatanl@folloze.com");
		fill(driver.findElement(By.cssSelector("input[name='password']")), "qazwsxedc");
		click(driver.findElement(By.cssSelector("button[type='submit']")));
		click(driver.findElement(By.className("item-selector")));
		click(driver.findElement(By.id("popup_button_select")));
		driver.switchTo().window(winHandleMain);
		Thread.sleep(2000);
		click(driver.findElement(By.linkText("Add")));
	}
	
	public void addNewGroup(){
		ExplicitWaitText(driver, "Add Group");
		click(driver.findElement(By.cssSelector(".ng-scope>a.btn.btn-big")));
		fill(driver.findElement(By.cssSelector("input[placeholder='New group name']")), "ALPHA");
		click(driver.findElement(By.cssSelector("input[type='submit']")));
	}
	
}
