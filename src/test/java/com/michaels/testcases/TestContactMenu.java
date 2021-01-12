package com.michaels.testcases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.michaels.base.Base;
import com.michaels.pages.StoreLocatorPage;

public class TestContactMenu extends Base{

	StoreLocatorPage slpage;
	
	
	@BeforeMethod
	public void getReady()
	{
		init();
		slpage = new StoreLocatorPage();
	}
	
	@Test(priority=1)
	public void testContact()
	{
		ArrayList<String> contact_menu = new ArrayList<String>();
		
		contact_menu.add("CONTACT US");
		contact_menu.add("CLICK TO CHAT");
		contact_menu.add("STORE LOCATOR");
		contact_menu.add("1-800-MICHAELS");
		
		Assert.assertEquals(slpage.contactVisibility(), contact_menu);
	}
	
	@AfterMethod
	public void terminate()
	{
		dr.close();
	}
	
}
