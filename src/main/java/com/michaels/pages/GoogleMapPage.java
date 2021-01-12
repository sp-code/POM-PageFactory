package com.michaels.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.michaels.base.Base;

public class GoogleMapPage extends Base{
	

	@FindBy(xpath="//*[@id='sb_ifc51']/input")
	WebElement addressInMap;
	
	

	public GoogleMapPage() {
		PageFactory.initElements(dr,this);
	}

	public boolean getSentAddress() {
		ArrayList<String> tabs = new ArrayList<String>(dr.getWindowHandles());

		dr.switchTo().window(tabs.get(1));

		wait.until(ExpectedConditions.visibilityOf(addressInMap));
		return addressInMap.isDisplayed();

	}

}
