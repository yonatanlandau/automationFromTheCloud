package com.folloze.tests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.folloze.pages.BoardPage;
import com.folloze.pages.ChannelUI;
import com.folloze.pages.Login;
import com.folloze.pages.MySettings;
import com.folloze.pages.Onboarding;
import com.folloze.utils.Utils;


public class NewTest {

	private WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver = Utils.getDriver("http://app.folloze.com");
	}

//	@Test (priority=1)
//	public void LoginError(){
//		Login log1 = new Login(driver);
//		log1.signInEmail("admino123@yopmail.com", "xxxxxx");
//		Assert.assertEquals(log1.isSignInError(), true);
//	}
	
	@Test (priority=2)
	public void LoginSuccess(){
		Login log1 = new Login(driver);
		log1.signInEmail("admin@follozeqa.com", "qwer1234");
		Onboarding onB = new Onboarding(driver);
		Assert.assertEquals(onB.isSignedIn(), true);
	}

//	@Test (priority=3)
//	public void newChannel(){
//		Onboarding onB = new Onboarding(driver);
//		onB.createChannel();
//		Assert.assertEquals(onB.isChannelCreated(), true);
//	}
	
	@Test (priority=4)
	public void createBoard() throws InterruptedException{
		Onboarding onB = new Onboarding(driver);
		BoardPage boardP = new BoardPage(driver);
		onB.createBoard();
		Assert.assertEquals(onB.isBoardCreated(), "TestBoard1111");
		//boardP.backToMyContent();
	}
	
//	@Test (priority=5)
//	public void addBoardToChannel() throws InterruptedException{
//		Onboarding onB = new Onboarding(driver);
//		onB.addBoard2Channel();
//		Assert.assertEquals(onB.isChannelIndicator(), true);
//	}
//	
//	@Test (priority=6)
//	public void favoriteBoard(){
//		Onboarding onB = new Onboarding(driver);
//		String exName = onB.boardNameAtMyContent();
//		onB.favBoard();
//		String acName = onB.boardNameAtFavorites();
//		Assert.assertEquals(exName, acName);
//	}
//	
//	@Test (priority=7)
//	public void inviteToChannel() throws InterruptedException{
//		Onboarding onB = new Onboarding(driver);
//		ChannelUI chUI = new ChannelUI(driver);
//		onB.navToChannel();
//		chUI.invite();
//		Assert.assertEquals(chUI.isInvited(), "viewertest02@yopmail.com");
//		chUI.exitInviteModal();
//		onB.backToMyContent();
//	}
//	
//	@Test (priority=8)
//	public void addItemsToBoard() throws InterruptedException{
//		Onboarding onB = new Onboarding(driver);
//		BoardPage boardP = new BoardPage(driver);
//		onB.openSecondBoard();
//		boardP.addLinkItem();
//		Assert.assertEquals(boardP.isLinkAdded(), "ynet - �����, �����, �����, ������");
//	}
	
	@Test (priority=9)
	public void inviteToBoard() throws InterruptedException{
		BoardPage boardP = new BoardPage(driver);
		boardP.shareBoard("editor@follozeqa.com");
		Assert.assertEquals(boardP.isBoardShared("editor@follozeqa.com"), "editor@follozeqa.com");
		boardP.closeShareModal();
		//boardP.backToMyContent();	
	}
	
//	@Test (priority=10)
//	public void changeUserSettings() throws InterruptedException{
//		Onboarding onB = new Onboarding(driver);
//		MySettings myS = new MySettings(driver);
//		onB.userSettings();
//		myS.firstNameAndLastName();
//		Assert.assertEquals(myS.isFandLnameChanged(), true);
//		myS.backToMyContent();
//	}
//	
//	@Test (priority=11)
//	public void searchForBoards() throws InterruptedException{
//		Onboarding onB = new Onboarding(driver);
//		onB.searchBoard();
//		Assert.assertEquals(onB.isSearchOK(), true);
//	}
//	
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}
	
}
