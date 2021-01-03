package com.michaels.testcases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.michaels.base.Base;
import com.michaels.pages.StoreLocatorPage;

public class TestOpeningDays extends Base{

	StoreLocatorPage slpage;
	String city = "santa clara";
	
	@BeforeMethod
	public void getReady()
	{
		init();
		slpage = new StoreLocatorPage(dr);
	}
	
	
	@Test(priority=1)
	public void testOpeningDays()
	{
		slpage.selectStoreFilters(city);
		
		
		ArrayList<String> expected_days = new ArrayList<String>();
		
		expected_days.add("Mon:");
		expected_days.add("Tue:");
		expected_days.add("Wed:");
		expected_days.add("Thu:");
		expected_days.add("Fri:");
		expected_days.add("Sat:");
		expected_days.add("Sun:");
		
		
		boolean result = slpage.openDays().containsAll(expected_days);
		
		
		Assert.assertEquals(result, true);
	}
	
	
	@AfterMethod
	public void terminate()
	{
		dr.close();
	}
}
