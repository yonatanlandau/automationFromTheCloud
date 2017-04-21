package com.folloze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChannelUI extends BasePage{

	WebDriver driver;

	public ChannelUI(WebDriver driver) {
		this.driver = driver;
	}
	
	public void invite() throws InterruptedException{
		WebElement channelMenuIcon = driver.findElement(By.cssSelector(".home-container>.container-right>.boards-view-container>.boards-view-header>.channel-menu-component>.popover-menu-component"));
		click(channelMenuIcon);
		WebElement channelMenuOpenInvite = driver.findElement(By.xpath(".//*[@id='app']/div/div[2]/div[2]/div/div[1]/div/div/ul/li[1]"));
		click(channelMenuOpenInvite);
		WebElement inputFld = driver.findElement(By.cssSelector(".add-emails-component>form>input"));
		fill(inputFld, "viewertest02@yopmail.com");
		sleep();
		WebElement addInviteMail = driver.findElement(By.cssSelector(".matching-emails-component>ul>:nth-child(1)>.name"));
		click(addInviteMail);
		sleep();
		WebElement inviteBtn = driver.findElement(By.cssSelector(".modal-buttons>:nth-child(2)"));
		click(inviteBtn);
		sleep();
	}
	
	public String isInvited(){
		WebElement channelMenuIcon = driver.findElement(By.cssSelector(".home-container>.container-right>.boards-view-container>.boards-view-header>.channel-menu-component>.popover-menu-component"));
		click(channelMenuIcon);
		WebElement channelMenuOpenInvite = driver.findElement(By.xpath(".//*[@id='app']/div/div[2]/div[2]/div/div[1]/div/div/ul/li[1]"));
		click(channelMenuOpenInvite);
		WebElement subscribersTab = driver.findElement(By.cssSelector(".ReactTabs__TabList.tab-list>:nth-child(2)"));
		click(subscribersTab);
		String inviteeMail = driver.findElement(By.cssSelector("tbody>tr>:nth-child(3)")).getText();
		return inviteeMail;
	}
	
	
}
