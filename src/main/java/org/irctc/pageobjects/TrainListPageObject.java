package org.irctc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TrainListPageObject {
	
	WebDriver driver;
	public TrainListPageObject(WebDriver driver){
		this.driver =driver;
	}
	private By vishakaexp =  By.xpath("//strong[text()=' VISAKHA EXPRESS (17015)']");
    private By vishakaTrainSchedule =  By.xpath("//strong[text()=' VISAKHA EXPRESS (17015)']/parent::div/following-sibling::div/child::div[@class='pull-right']/child::strong/child::span/child::span");
    
    public void goToVishakaExpAndClickTrainScheduleLink() {
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("arguments[0].scrollIntoView(true);", "vishakaexp");
        driver.findElement(vishakaTrainSchedule).click();
    }

}
