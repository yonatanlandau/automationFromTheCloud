package com.folloze.pages;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BoardPage extends BasePage{

	WebDriver driver;

	public BoardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void addLinkItem() throws InterruptedException {
		click(driver.findElement(By.cssSelector(".add-content-bar>:nth-child(1)")));
		click(driver.findElement(By.cssSelector(".add-content-bar>.content-btn.first")));
		fill(driver.findElement(By.cssSelector("input[type='url']")), "http://www.ynet.co.il");
		ExplicitWaitText(driver, "Find more images");
		click(driver.findElement(By.xpath("html/body/modals-list/div/ul/li/modal/form/div/div/div[2]/a[2]")));
		sleep();
	}
	
	public String isLinkAdded(){
		String itemLink = driver.findElement(By.xpath(".//*[@id='ngApp']/div/div/div/div/div/div/div/ul[2]/li[1]/div[2]/div/div/div[1]/a/h3")).getText();
		return itemLink;
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
	
	public void shareBoard(String inviteer) throws InterruptedException{
		
		WebElement shareIcon = driver.findElement(By.cssSelector(".share-icon"));
		ExplicitWaitClick(driver, shareIcon);
		click(shareIcon);
		WebElement editorSet = driver.findElement(By.xpath("//ul/li[1]/h3/span[1]/a"));
		ExplicitWaitClick(driver, editorSet);
		click(editorSet);
		WebElement mailField = driver.findElement(By.cssSelector(".inline-selector.ng-scope.ng-isolate-scope.ng-empty.ng-valid.ng-valid-email>.inline-selector-input-container>input"));
		fill(mailField, inviteer);
		mailField.sendKeys(Keys.ENTER);
		WebElement sendInvites = driver.findElement(By.xpath("//div/div[3]/a[2]"));
		click(sendInvites);
		//sleep();
	}
	
	public String isBoardShared(String inviteer) throws InterruptedException{
		sleep();
		WebElement shareIcon = driver.findElement(By.cssSelector(".share-icon"));
		click(shareIcon);
		WebElement searchBar = driver.findElement(By.cssSelector(".container-right>input"));
		fill(searchBar, inviteer);
		sleep();
		String mail = driver.findElement(By.xpath("//ul/li[2]/div/div[2]/span")).getText();
		return mail;
	}
	
	public void closeShareModal(){
		WebElement closeModal = driver.findElement(By.cssSelector(".btn.btn-big.ng-binding.ng-scope"));
		click(closeModal);
	}
	
	public void backToMyContent() throws InterruptedException{
		sleep();
		WebElement backToHome = driver.findElement(By.xpath(".//*[@id='app']/div/div[1]/div[1]/a/span"));
		click(backToHome);
		sleep();
	}
	
}
