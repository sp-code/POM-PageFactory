package com.michaels.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.michaels.base.Base;

public class StorePage extends Base{

	
	
	@FindBy(xpath="//div[@class='address-block']/div[1]")
	WebElement StoreName;
	
	
	@FindBy(xpath="//a[@class='ga_w2gi_lp']/span")
	WebElement store_phone_number;
	
	
	public StorePage()
	   {
		   PageFactory.initElements(dr,this);
	   }
	
	public String getStoreName()
	{
		ArrayList<String> tabs = new ArrayList<String>(dr.getWindowHandles());

		dr.switchTo().window(tabs.get(1));
		
		return StoreName.getText();
	}
	
	public String getPhoneNumber()
	{
		ArrayList<String> tabs = new ArrayList<String>(dr.getWindowHandles());
		
		dr.switchTo().window(tabs.get(1));
		
		return store_phone_number.getText();
		
		
	}
	
}
