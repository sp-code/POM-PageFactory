package com.michaels.testcases;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.michaels.base.Base;
import com.michaels.pages.StoreLocatorPage;
import com.michaels.pages.StorePage;

public class TestStoreInformation extends Base{

	
	StoreLocatorPage slpage;
	StorePage spage;
	
	String city = "santa clara";
	
	@BeforeMethod
	public void getReady()
	{
		init();
		slpage = new StoreLocatorPage(dr);
		spage = new StorePage(dr);
	}
	
	@Test(priority=1)
	public void verifyStoreName()
	{
		slpage.selectStoreFilters(city);
		
		String storeName = slpage.storeInformationName(); //Store name on store locator
		
		slpage.visitStorePage();
		
		String storeNameOnStorePage = spage.getStoreName();  //store name on store page
		
		storeNameOnStorePage = storeNameOnStorePage.toUpperCase();
		
		Assert.assertEquals(storeNameOnStorePage, storeName);
	} 
	
	@Test(priority=2)
	public void verifyStoreNumber() 
	{
		slpage.selectStoreFilters(city);
		
		String number = slpage.storeInformationNumber();
		
		slpage.visitStorePage();
		
		String storePhoneOnPage = spage.getPhoneNumber();
		
		Assert.assertEquals(number, storePhoneOnPage);
		
		
	}
	
}
