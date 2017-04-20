package com.folloze.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.folloze.pages.BoardPage;
import com.folloze.pages.Login;
import com.folloze.pages.Onboarding;


public class NewTest {

	private WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "C:/Users/FollozePC/projects/TestsInCloud/src/test/resources/chromedriver2.exe");
		driver = new ChromeDriver();
		driver.get("http://app.folloze.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@Test (priority=1)
	public void LoginTrue() throws Exception {
		Login log1 = new Login(driver);
		log1.signInEmail("sivan@sivan.com", "qaqa1111");
		Onboarding onB = new Onboarding(driver);
		Assert.assertEquals(onB.isSignedIn(), "https://app.folloze.com/app/my_content");
	}
	
	@Test (priority=2)
	public void newChannel(){
		Onboarding onB = new Onboarding(driver);
		onB.createChannel();
	}
	
	@Test (priority=3)
	public void createBoard() throws InterruptedException{
		Onboarding onB = new Onboarding(driver);
		BoardPage boardP = new BoardPage(driver);
		onB.createBoard();
		Assert.assertEquals(onB.isBoardCreated(), "TestBoard1111");
		boardP.backToMyContent();
	}
	
	@Test (priority=4)
	public void addBoardToChannel() throws InterruptedException{
		Onboarding onB = new Onboarding(driver);
		onB.addBoard2Channel();
		Assert.assertEquals(onB.isChannelIndicator(), true);
	}
	
	@Test (priority=5)
	public void favoriteBoard(){
		Onboarding onB = new Onboarding(driver);
		String exName = onB.boardNameAtMyContent();
		onB.favBoard();
		String acName = onB.boardNameAtFavorites();
		Assert.assertEquals(exName, acName);
	}
	
	
	
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}
	
}
