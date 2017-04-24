package com.folloze.tests;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.folloze.pages.BoardPage;
import com.folloze.pages.ChannelUI;
import com.folloze.pages.Login;
import com.folloze.pages.MySettings;
import com.folloze.pages.Onboarding;


public class NewTest {

	private WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "C:/Users/FollozePC/projects/TestsInCloud/src/test/resources/chromedriver2.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("--start-maximized");
	    options.addArguments("--disable-web-security");
	    options.addArguments("--no-proxy-server");
	    Map<String, Object> prefs = new HashMap<String, Object>();
	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
	    options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		driver.get("http://app.folloze.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@Test (priority=1)
	public void LoginTrue() throws Exception {
		Login log1 = new Login(driver);
		log1.signInEmail("admino123@yopmail.com", "qwer1234");
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
	
	@Test (priority=6)
	public void inviteToChannel() throws InterruptedException{
		Onboarding onB = new Onboarding(driver);
		ChannelUI chUI = new ChannelUI(driver);
		onB.navToChannel();
		chUI.invite();
		Assert.assertEquals(chUI.isInvited(), "viewertest02@yopmail.com");
		chUI.exitInviteModal();
		onB.backToMyContent();
	}
	
	@Test (priority=7)
	public void addItemsToBoard() throws InterruptedException{
		Onboarding onB = new Onboarding(driver);
		BoardPage boardP = new BoardPage(driver);
		onB.openSecondBoard();
		boardP.addLinkItem();
		Assert.assertEquals(boardP.isLinkAdded(), "ynet - חדשות, כלכלה, ספורט, בריאות");
	}
	
	@Test (priority=8)
	public void inviteToBoard() throws InterruptedException{
		BoardPage boardP = new BoardPage(driver);
		boardP.shareBoard();
		Assert.assertEquals(boardP.isBoardShared(), "editortest01prod@yopmail.com");
		boardP.closeShareModal();
		boardP.backToMyContent();	
	}
	
	@Test (priority=9)
	public void changeUserSettings() throws InterruptedException{
		Onboarding onB = new Onboarding(driver);
		MySettings myS = new MySettings(driver);
		onB.userSettings();
		myS.firstNameAndLastName();
		Assert.assertEquals(myS.isFandLnameChanged(), true);
		myS.backToMyContent();
	}
	
	@Test (priority=10)
	public void searchForBoards() throws InterruptedException{
		Onboarding onB = new Onboarding(driver);
		onB.searchBoard();
		Assert.assertEquals(onB.isSearchOK(), true);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
