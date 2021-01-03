package com.michaels.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.michaels.base.Base;
import com.michaels.pages.HomePage;
import com.michaels.pages.StoreLocatorPage;

  public class TestTopMenu extends Base{
	  
   HomePage hppage;
	
	
	@BeforeMethod
	public void getReady()
	{
		init();
		hppage = new HomePage(dr);
	}
	
	@Test(priority=1)
	public void testLogo()
	{
		Assert.assertEquals(hppage.logo(),true);
	}
	
	@Test(priority=2)
	public void testCustomFraming()
	{
		Assert.assertEquals(hppage.customFraming(),true);
	}
	
	@Test(priority=3)
	public void testMichaelsReward()
	{
		Assert.assertEquals(hppage.michaelReward(),true);	
	}
	
	@Test(priority=4)
	public void testGiftCard()
	{
		Assert.assertEquals(hppage.giftCard(),true);	
	}
	
	@Test(priority=5)
	public void testClassesAndEvents()
	{
		Assert.assertEquals(hppage.classesAndEvents(),true);	
	}
	@Test(priority=6)
	public void testCoupons()
	{
		Assert.assertEquals(hppage.coupons(),true);	
	}
	
	
	@AfterMethod
	public void terminate()
	{
		dr.close();
	}
}
