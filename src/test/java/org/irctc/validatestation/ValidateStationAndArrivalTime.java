package org.irctc.validatestation;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.irctc.dataUtils.MysqlCon;
import org.irctc.logs.IrctcLogs;
import org.irctc.pageobjects.LandingPageObject;
import org.irctc.pageobjects.TrainListPageObject;
import org.irctc.pageobjects.TrainSchedulePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidateStationAndArrivalTime {
	
	WebDriver driver;
	Logger log;
	String stations[];
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\\\\\\\softwares\\\\\\\\chromedriver_win32_109\\\\\\\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		System.out.println("returned from DB : "+MysqlCon.getStations()[0]);
		
		stations=MysqlCon.getStations();
	}
	
	
	@Test
	public void vlaidateStationAndArrivalTime() throws InterruptedException {
		System.out.println("starting test ......");
		log =IrctcLogs.irctclLogger(ValidateStationAndArrivalTime.class);
		log.info("starting validating station and time..");
		LandingPageObject landingPageObject = new LandingPageObject(driver);
	
		landingPageObject.enterFromStation(stations[0]);
		landingPageObject.enterToStation(stations[1]);
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
