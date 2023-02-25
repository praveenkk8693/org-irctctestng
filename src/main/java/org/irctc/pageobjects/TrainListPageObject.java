package org.irctc.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TrainListPageObject {
	
	WebDriver driver;
	public TrainListPageObject(WebDriver driver){
		this.driver =driver;
	}
	private By vishakaexp =  By.xpath("//strong[text()=' VISAKHA EXPRESS (17015)']");
    private By vishakaTrainSchedule =  By.xpath("//strong[text()=' VISAKHA EXPRESS (17015)']/parent::div/following-sibling::div/child::div[@class='pull-right']/child::strong/child::span/child::span[text()='Train Schedule']");
    
    public void goToVishakaExpAndClickTrainScheduleLink() throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(vishakaexp));
    	jse.executeScript("arguments[0].style.border='3px solid red'",driver.findElement(vishakaexp));
    	Thread.sleep(3000);
        //driver.findElement(vishakaTrainSchedule).click();
    	jse.executeScript("arguments[0].click()", driver.findElement(vishakaTrainSchedule));
    }

}
