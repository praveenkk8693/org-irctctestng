package org.irctc.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class LandingPageObject {
	WebDriver driver;
	public LandingPageObject(WebDriver driver){
		this.driver =driver;
	}

	private By fromStation = By.xpath("//span[@class='ng-tns-c57-8 ui-autocomplete ui-widget']/child::input");
	private By toStation = By.xpath("//span[@class='ng-tns-c57-9 ui-autocomplete ui-widget']/child::input");
	//private By dateIcon  =  By.xpath("//input[@class='ng-tns-c58-10 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']");
    private By dateOfJourney = By.xpath("//span[@class='ng-tns-c58-10 ui-calendar']");
    private By monthAndYear = By.xpath("//div[@class='ui-datepicker-title ng-tns-c58-10']//span");
    private By dateNextArrowIcon = By.xpath("//a[@class='ui-datepicker-next ui-corner-all ng-tns-c58-10 ng-star-inserted']");
    // //table[@class='ui-datepicker-calendar ng-tns-c58-10']//td
    private By day = By.xpath("//table[@class='ui-datepicker-calendar ng-tns-c58-10']//a");
    
  
    private By classesDropdown = By.xpath("//span[@class='ng-tns-c65-11 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']");
//    private By classesDropdown = By.xpath("//div[@class='ng-tns-c65-11 ui-dropdown ui-widget ui-state-default ui-corner-all ui-dropdown-open']");
    private By className  =  By.xpath("//span[text()='Sleeper (SL)']");
    private By quotaDropDown =  By.xpath("//div[@class='ng-tns-c65-12 ui-dropdown ui-widget ui-state-default ui-corner-all']");
    private By quotaName = By.xpath("//span[text()='TATKAL']");
    private By availableBerth =By.xpath("//label[@for='availableBerth']");
    private By searchButton =  By.xpath("//button[@class='search_btn train_Search']");
    
    public void enterFromStation(String fromStationVal) throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	driver.findElement(fromStation).sendKeys(fromStationVal);
    	Thread.sleep(2000);
    	driver.findElement(fromStation).sendKeys(Keys.ENTER);
    }
    
    public void enterToStation(String toStationVal) throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	driver.findElement(toStation).sendKeys(toStationVal);
    	Thread.sleep(2000);
    	driver.findElement(toStation).sendKeys(Keys.ENTER);
    }
    
    public void selectTravelDate() {
    	String actualDate =  "27-February-2023";
    	String arr[] = actualDate.split("-");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	driver.findElement(dateOfJourney).click();
    	while(true) {
    		
    		
        	List<WebElement> list =  driver.findElements(monthAndYear);
        	System.out.println(list.get(0).getText());
        	System.out.println(list.get(1).getText());
    		if(list.get(0).getText().equals(arr[1])&&list.get(1).getText().equals(arr[2])) {
    			break;
    		}else {
    			driver.findElement(dateNextArrowIcon).click();
    		}
    	}
    	List<WebElement> dayList = driver.findElements(day);
    	for(WebElement dayEle: dayList) {
    		if(dayEle.getText().equals(arr[0])) {
    			System.out.println(dayEle.getText());
    			dayEle.click();
    			break;
    		}
    	}
    	
    }
    
    public void selectClass() {
    	driver.findElement(classesDropdown).click();
    	driver.findElement(className).click();
    }
    
    public void selectQuota() {
    	driver.findElement(quotaDropDown).click();
    	driver.findElement(quotaName).click();
    }
    
    public void selectAvailableBerthCheckBox() {
    	driver.findElement(availableBerth).click();
    }
    public void clickSearchButton() {
    	driver.findElement(searchButton).click();
    }
}
