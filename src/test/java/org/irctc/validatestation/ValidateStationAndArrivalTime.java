package org.irctc.validatestation;

import org.apache.log4j.Logger;
import org.irctc.logs.IrctcLogs;
import org.irctc.pageobjects.LandingPageObject;
import org.irctc.pageobjects.TrainListPageObject;
import org.irctc.pageobjects.TrainSchedulePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidateStationAndArrivalTime {
	
	WebDriver driver;
	Logger log;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\\\\\\\softwares\\\\\\\\chromedriver_win32_109\\\\\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
	}
	
	
	@Test
	public void vlaidateStationAndArrivalTime() {
		System.out.println("starting test ......");
		IrctcLogs.irctclLogger(ValidateStationAndArrivalTime.class);
		log.info("starting validating station and time..");
		LandingPageObject landingPageObject = new LandingPageObject(driver);
		landingPageObject.enterFromStation();
		landingPageObject.enterToStation();
		landingPageObject.selectTravelDate();
		landingPageObject.selectClass();
		landingPageObject.selectQuota();
		landingPageObject.selectAvailableBerthCheckBox();
		landingPageObject.clickSearchButton();
		
		TrainListPageObject trainListPageObject = new TrainListPageObject(driver);
		trainListPageObject.goToVishakaExpAndClickTrainScheduleLink();
		
		TrainSchedulePageObject trainSchedulePageObject  = new TrainSchedulePageObject(driver);
		Assert.assertTrue(trainSchedulePageObject.verifyStationNameAndArrivalTime());
	}
	

}
