package com.michaels.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.michaels.base.Base;

public class GoogleMapPage extends Base {

	By addressInMap = By.xpath("//*[@id='sb_ifc51']/input");

	public GoogleMapPage(WebDriver dr) {
		this.dr = dr;
	}

	public boolean getSentAddress() {
		ArrayList<String> tabs = new ArrayList<String>(dr.getWindowHandles());

		dr.switchTo().window(tabs.get(1));

		wait.until(ExpectedConditions.visibilityOfElementLocated(addressInMap));
		return dr.findElement(addressInMap).isDisplayed();

	}

}
