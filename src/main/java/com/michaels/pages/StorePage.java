package com.michaels.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.michaels.base.Base;

public class StorePage extends Base{

	WebDriver dr;
	
	By StoreName = By.xpath("//div[@class='address-block']/div[1]");
	
	By store_phone_number = By.xpath("//a[@class='ga_w2gi_lp']/span");
	
	public StorePage(WebDriver dr)
	   {
		   this.dr= dr;
	   }
	
	public String getStoreName()
	{
		ArrayList<String> tabs = new ArrayList<String>(dr.getWindowHandles());

		dr.switchTo().window(tabs.get(1));
		
		return dr.findElement(StoreName).getText();
	}
	
	public String getPhoneNumber()
	{
		ArrayList<String> tabs = new ArrayList<String>(dr.getWindowHandles());
		
		dr.switchTo().window(tabs.get(1));
		
		return dr.findElement(store_phone_number).getText();
		
		
	}
	
}
