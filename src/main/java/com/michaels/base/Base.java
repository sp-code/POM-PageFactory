package com.michaels.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public static  WebDriver dr; //we have declared below method as static thus we need to declare this variable as static
	public static WebDriverWait wait;
	
	
	public static void init()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SP\\eclipse-workspace\\project\\src\\main\\resources\\executables\\chromedriver.exe");
		
		dr = new ChromeDriver();
		
		
		dr.get("https://www.michaels.com/store-locator");
		
		dr.manage().window().maximize();
		
		dr.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
		
		wait=new WebDriverWait(dr, 10);
		
		dr.switchTo().frame("locatoriframe");
	
	}
	
}
