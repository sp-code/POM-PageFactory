package com.michaels.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.michaels.base.Base;
import com.michaels.pages.GoogleMapPage;
import com.michaels.pages.StoreLocatorPage;

public class TestMapAddress extends Base {

	StoreLocatorPage slpage;
	GoogleMapPage gmppage;
	String city = "santa clara";

	@BeforeMethod
	public void getReady() {
		init();
		slpage = new StoreLocatorPage(dr);
		gmppage = new GoogleMapPage(dr);
	}

	@Test(priority = 1)
	public void checkDirection() {
		slpage.selectStoreFilters(city);

		slpage.getDirection();

		boolean sent_address = gmppage.getSentAddress();

		Assert.assertEquals(sent_address, true);

	}

}
