package com.folloze.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Onboarding extends BasePage{

	WebDriver driver;
	WebDriverWait wait;
	
	public Onboarding(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public String isSignedIn(){
		ExplicitWaitClick(driver, driver.findElement(By.className("popover-menu-icon")));
		String url = driver.getCurrentUrl();
		return url;
	}
	
	
	public void createChannel(){
		WebElement addNew = driver.findElement(By.className("main-button"));
		click(addNew);
		WebElement newChannel = driver.findElement(By.xpath(".//*[@id='app']/div/div[2]/div[1]/div/div/button[2]"));
		click(newChannel);
		WebElement channelName = driver.findElement(By.cssSelector("form>input"));
		fill(channelName, "TestChannel111");
		WebElement createChannel = driver.findElement(By.cssSelector(".modal-buttons>button:nth-child(2)"));
		click(createChannel);
		ExplicitWaitText(driver, "TestChannel111");
	}
	
	public void createBoard() throws InterruptedException{
		WebElement newBoard = driver.findElement(By.xpath(".//*[@id='app']/div/div[2]/div[1]/div/div/button[1]"));
		click(newBoard);
		WebElement boardName = driver.findElement(By.xpath("html/body/modals-list/div/ul/li/modal/div/div[2]/form/div/form/ul[1]/li[1]/input"));
		fill(boardName, "TestBoard1111");
		sleep();
		WebElement createBoard = driver.findElement(By.linkText("Create"));
		click(createBoard);
	}
	
	public String isBoardCreated(){
		String boardTitle = driver.findElement(By.cssSelector(".header-data>h1")).getText();
		return boardTitle;
	}

	public void addBoard2Channel() throws InterruptedException{
		WebElement logo = driver.findElement(By.cssSelector(".header-button.home-button-container"));
		click(logo);
		Actions builder = new Actions(driver);
		WebElement firstBoard = driver.findElement(By.cssSelector(".boards-container>:nth-child(1)"));
		builder.moveToElement(firstBoard).build().perform();
		WebElement menuIcon = driver.findElement(By.cssSelector(".boards-container>:nth-child(1)>.header>.board-menu-component>.popover-menu-component>.popover-menu-icon-container"));
		click(menuIcon);
		WebElement addTo = driver.findElement(By.cssSelector(".boards-container>:nth-child(1)>.header>.board-menu-component>.popover-menu-component>.opened>:nth-child(6)>.popover-menu-component>.popover-menu-icon-container>.submenu"));
		click(addTo);
		WebElement channelSelection = driver.findElement(By.cssSelector(".boards-container>:nth-child(1)>.header>.board-menu-component>.popover-menu-component>.opened>:nth-child(6)>.popover-menu-component>.opened>:nth-child(4)"));
		click(channelSelection);
		driver.navigate().refresh();
		sleep();
	}
	
	public boolean isChannelIndicator() throws InterruptedException{
		boolean indi = false;
		WebElement att = driver.findElement(By.xpath(".//*[@id='app']/div/div[2]/div[1]/ul/li[5]/a"));
		String att2 = att.getAttribute("class");
		if(att2.contains("alert")){
			indi = true;
		}
		return indi;
	}
	
	public void favBoard(){
		WebElement logo = driver.findElement(By.cssSelector(".header-button.home-button-container"));
		click(logo);
		Actions builder = new Actions(driver);
		WebElement firstBoard = driver.findElement(By.cssSelector(".boards-container>:nth-child(2)"));
		builder.moveToElement(firstBoard).build().perform();
		WebElement favIcon = driver.findElement(By.cssSelector(".boards-container>:nth-child(2)>.header>.favorite-button-component"));
		click(favIcon);
		WebElement favorites = driver.findElement(By.cssSelector(".favorites"));
		click(favorites);
		
		
		//
	}
	
	public String boardNameAtMyContent(){
		String secondBoard = driver.findElement(By.cssSelector(".boards-container>:nth-child(2)>.title")).getText();
		return secondBoard;
	}
	
	public String boardNameAtFavorites(){
		String boardName = driver.findElement(By.cssSelector(".boards-container>.board-tile>.title")).getText();
		return boardName;
	}
	
	public void signOut(){
		ExplicitWaitText(driver, "yopAdmin");
		click(driver.findElement(By.cssSelector(".user-link.ng-binding")));
		click(driver.findElement(By.cssSelector(".header-add-dropdown.ng-scope>a:nth-child(6)")));
	}
	
	
	

	
	
}
