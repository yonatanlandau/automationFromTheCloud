package com.folloze.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MySettings extends BasePage{

	WebDriver driver;
	
	public MySettings(WebDriver driver) {
		this.driver = driver;
	}

	public void firstNameAndLastName() throws InterruptedException{
		sleep();
		WebElement fName = driver.findElement(By.xpath(".//*[@id='ngApp']/div/div/div/div/div/form/dl[1]/dd[1]/input"));
		fill(fName, "test_First_Name");
		WebElement lName = driver.findElement(By.xpath(".//*[@id='ngApp']/div/div/div/div/div/form/dl[1]/dd[2]/input"));
		fill(lName, "test_Last_Name");
		WebElement save = driver.findElement(By.cssSelector(".btn.btn-important.btn-big"));
		click(save);
	}
	
	public boolean isFandLnameChanged(){
		boolean ans = false;
		String fandlName = driver.findElement(By.cssSelector(".name.ng-binding")).getText();
		if(fandlName.contains("Test_First_Name Test_Last_Name")){
			ans = true;
			return ans;
		}else{
			return ans;
		}
		
	}

	public void backToMyContent() throws InterruptedException{
		sleep();
		WebElement backToHome = driver.findElement(By.xpath(".//*[@id='app']/div/div[1]/div[1]/a/span"));
		click(backToHome);
		sleep();
	}
	
	
	
}
