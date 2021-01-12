package com.michaels.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.michaels.base.Base;

public class HomePage extends Base{

	/*Logo*/
	@FindBy(xpath="//*[@id='michaelslink']/img")
	WebElement logo;
	
	
	@FindBy(xpath="//a[@id='michaelscflink']/img")
	WebElement custom_framing;
	
	
	@FindBy(xpath="//ul[@class='menu-utility']/li[1]/a")
	WebElement michael_reward;
	
	
	@FindBy(xpath="//ul[@class='menu-utility']/li[2]/a")
	WebElement gift_cards;
	
	
	@FindBy(xpath="//ul[@class='menu-utility']/li[3]/a")
	WebElement classes_and_events;
	
	@FindBy(xpath="//ul[@class='menu-utility']/li[4]/a")
	WebElement coupons4;
	
	
	public HomePage()
	   {
		   PageFactory.initElements(dr,this);
		   
		   dr.get("https://www.michaels.com/");
	   }
	
	
	
	 public boolean logo()
	   {
		   dr.switchTo().parentFrame(); //important change
		   
		   return logo.isDisplayed();
	   }
	 
	 public boolean customFraming()
	 {
		 dr.switchTo().parentFrame(); 
		 wait.until(ExpectedConditions.visibilityOf(custom_framing));
		 return custom_framing.isDisplayed();
	 }
	 
	 
	 public boolean michaelReward()
	 {
		 dr.switchTo().parentFrame(); 
		 return michael_reward.isDisplayed();
	 }
	 
	 public boolean giftCard()
	 {
		 dr.switchTo().parentFrame(); 
		 return gift_cards.isDisplayed();
	 }
	 
	 public boolean classesAndEvents()
	 {
		 dr.switchTo().parentFrame();
		 return classes_and_events.isDisplayed(); 
	 }
	 public boolean coupons()
	 {
		 dr.switchTo().parentFrame();
		 return coupons4.isDisplayed(); 
	 }
	 
}
