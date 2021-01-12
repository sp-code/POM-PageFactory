package com.michaels.testcases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.michaels.base.Base;
import com.michaels.pages.StoreLocatorPage;


public class TestStoreFilter extends Base{

	StoreLocatorPage slpage;
	String city = "santa clara";
	
	@BeforeMethod
	public void getReady()
	{
		init();
		slpage = new StoreLocatorPage();
	}

	@Test(priority=1)
	public void filterButtonVisibility() throws InterruptedException
	{
		boolean ele = slpage.locateFilterButton();
		Assert.assertEquals(ele, true);
		
	}
	
	@Test(priority=2)
	public void filtercheckboxesVisibility() 
	{

		ArrayList<String> filters = new ArrayList<String>();
		   filters.add("UPS Access Point");
		   filters.add("Curbside Pickup");
		   filters.add("Same Day Delivery");
		   filters.add("In Store Shopping");   
		   
		   
		   
		Assert.assertEquals(slpage.verifyStoresFilter(city), filters);   
		
	} 
	
	@Test(priority=3)
	public void storeList() 
	{
		slpage.selectStoreFilters(city);
		
		ArrayList<String> actual_stores_names = new ArrayList<String>();
		
		actual_stores_names.add("1. SAN JOSE MARKETCENTER");
		actual_stores_names.add("2. HACIENDA SHOPPING CENTER");
		actual_stores_names.add("3. HOMESTEAD SQUARE SHOPPING CENTER");
		actual_stores_names.add("4. WESTGATE CENTER");
		actual_stores_names.add("5. MCCARTHY RANCH MARKETPLACE");
		actual_stores_names.add("6. S.JOS-TULLY");
		actual_stores_names.add("7. PRINCETON PLAZA");
		actual_stores_names.add("8. BAY-MOUNTAIN VIEW");
		actual_stores_names.add("9. SOUTHGATE SHOPPING CENTER");
		actual_stores_names.add("10. FREMONT HUB");
		
		Assert.assertEquals(actual_stores_names, slpage.getStoreList());   
		
	}
	
	@AfterMethod
	public void terminate()
	{
		dr.close();
	}
}
