package org.irctc.pageobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrainSchedulePageObject {
	
	WebDriver driver;
	public TrainSchedulePageObject(WebDriver driver){
		this.driver =driver;
	}
	
	private By getAllrows = By.xpath("//table[@class='table']//td");
	
	public boolean verifyStationNameAndArrivalTime() {
		
		//need to implement multiple windows logic
		Set <String> allHandles = driver.getWindowHandles();
		System.out.println("no of windows  " + allHandles.size());
		
		
		
		
		
		List<WebElement> list = driver.findElements(getAllrows);
		List<WebElement> siblings = new ArrayList<WebElement>();
		
		
		for(WebElement ele:list) {
			if(ele.getText().equals("29")) {
				List<WebElement> fSibs = ele.findElements(By.xpath("following-sibling::*"));
				siblings.addAll(fSibs);
			}
		}
		if(siblings.get(1).getText().equals("BHIMAVARAM TOWN")&& siblings.get(3).getText().equals("21:08")) {
			
			return true;
		}else {
			return false;
		}
	}

}
