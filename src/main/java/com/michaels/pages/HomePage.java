package com.michaels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.michaels.base.Base;

public class HomePage extends Base{

	/*Logo*/
	By logo = By.xpath("//*[@id='michaelslink']/img");
	
	By custom_framing = By.xpath("//a[@id='michaelscflink']/img");
	
	By michael_reward = By.xpath("//ul[@class='menu-utility']/li[1]/a");
	
	By gift_cards = By.xpath("//ul[@class='menu-utility']/li[2]/a");
	
	By classes_and_events = By.xpath("//ul[@class='menu-utility']/li[3]/a");
	
	By coupons4 = By.xpath("//ul[@class='menu-utility']/li[4]/a");
	
	
	public HomePage(WebDriver dr)
	   {
		   this.dr= dr;
		   
		   dr.get("https://www.michaels.com/");
	   }
	
	
	
	 public boolean logo()
	   {
		   dr.switchTo().parentFrame(); //important change
		   
		   return dr.findElement(logo).isDisplayed();
	   }
	 
	 public boolean customFraming()
	 {
		 dr.switchTo().parentFrame(); 
		 return dr.findElement(custom_framing).isDisplayed();
	 }
	 
	 
	 public boolean michaelReward()
	 {
		 dr.switchTo().parentFrame(); 
		 return dr.findElement(michael_reward).isDisplayed();
	 }
	 
	 public boolean giftCard()
	 {
		 dr.switchTo().parentFrame(); 
		 return dr.findElement(gift_cards).isDisplayed();
	 }
	 
	 public boolean classesAndEvents()
	 {
		 dr.switchTo().parentFrame();
		 return dr.findElement(classes_and_events).isDisplayed(); 
	 }
	 public boolean coupons()
	 {
		 dr.switchTo().parentFrame();
		 return dr.findElement(coupons4).isDisplayed(); 
	 }
	 
}
