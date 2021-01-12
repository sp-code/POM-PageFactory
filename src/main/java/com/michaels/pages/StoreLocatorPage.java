package com.michaels.pages;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import com.michaels.base.Base;

public class StoreLocatorPage extends Base{

	

	@FindBy(xpath="//*[@id='locator_search']/button")
	WebElement filterbtn;
	

	@FindBy(xpath="//input[@id='search_input']")
	WebElement search;	
	

	@FindBy(xpath="//div[@id='store_filters']/div/label")
	List<WebElement> storefilters;
	

	@FindBy(xpath="//button[@class='setFilters']")
	WebElement donebtn;
	
	
	@FindBy(xpath="//div[@id='store_filters']/div[2]")
	WebElement checkbox2;
	

	@FindBy(xpath="//div[@id='store_filters']/div[3]")
	WebElement checkbox4;
	

	@FindBy(xpath="//li[@class='poi-item']/div/div/div/h5")
	List<WebElement> storelist;
	


	@FindBy(xpath="//li[@class='poi-item']/div/div/div/h5")
	WebElement store_name;
	

	@FindBy(xpath="//a[@class='store_link']")
	WebElement store_link;
	
	
	@FindBy(xpath="//button[@class='hours_toggle']")
	WebElement open_days_btn;
	

	@FindBy(xpath="//div[@class='hours_inner']/div/span[1]")
	List<WebElement> all_days;


	/* Contact */
	@FindBy(xpath="//div[@class='static-content-leftnav']/ul/li")
	List<WebElement> contact;
	

	@FindBy(xpath="//a[@class='directions_link']")
	WebElement getDirection;
	
	
	@FindBy(xpath="//div[@class='address-wrapper']")
	WebElement storeAddress;
	
	
	@FindBy(xpath="//a[@class='store_link']")
	WebElement visit_store_page;
	
	
	@FindBy(xpath="//a[@class='store-phone']")
	WebElement phone;
	

	public StoreLocatorPage() {
		//this.dr = dr;
		PageFactory.initElements(dr,this);
	}

	public boolean locateFilterButton() throws InterruptedException {

		return filterbtn.isDisplayed();

	}

	public ArrayList<String> verifyStoresFilter(String city) {
		ArrayList<String> al = new ArrayList<String>();

		search.sendKeys(city);
		filterbtn.click();

		List<WebElement> elements = storefilters;
		
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));

		for (WebElement ele : elements) {
			al.add(ele.getText());
		}
		return al;

	}

	public void selectStoreFilters(String city) {
		search.sendKeys(city);
		filterbtn.click();

		wait.until(ExpectedConditions.visibilityOf(checkbox2));
		wait.until(ExpectedConditions.visibilityOf(checkbox4));

		checkbox2.click();
		checkbox4.click();
		donebtn.click();
	}
	
	public ArrayList<String> getStoreList() {
		ArrayList<String> storesname = new ArrayList<String>();

		wait.until(ExpectedConditions.visibilityOfAllElements(storelist));

		List<WebElement> elements = storelist;

		for (WebElement ele : elements) {
			storesname.add(ele.getText());
		}
		return storesname;

	}

	public String storeInformationName() {
		
		wait.until(ExpectedConditions.visibilityOf(store_name));

		String storeName = store_name.getText();

		storeName = storeName.replaceAll("[\\d.]", "");

		storeName = storeName.trim();

		return storeName;

	}

	public String storeInformationNumber() {

		wait.until(ExpectedConditions.visibilityOf(phone));
		return phone.getText();
		
	}

	public ArrayList<String> contactVisibility() {
		dr.switchTo().parentFrame(); // important change

		ArrayList<String> contactmenu = new ArrayList<String>();

		List<WebElement> elements = contact;

		for (WebElement ele : elements) {
			contactmenu.add(ele.getText());
		}

		return contactmenu;
	}

	public ArrayList<String> openDays() {
		
		wait.until(ExpectedConditions.visibilityOf(open_days_btn));

		ArrayList<String> days = new ArrayList<String>();

		open_days_btn.click();

		//wait.until(ExpectedConditions.visibilityOfAllElements(all_days));

		List<WebElement> elements = all_days;

		for (WebElement ele : elements) {
			days.add(ele.getText());
		}
		return days;
	}

	public String getStoreAddress() {
		wait.until(ExpectedConditions.visibilityOf(storeAddress));
		String store_address = storeAddress.getText();
		return store_address;
	}
	
	
	public void visitStorePage()
	{
		wait.until(ExpectedConditions.visibilityOf(visit_store_page));
		visit_store_page.click();
	}

	public void getDirection() {

		wait.until(ExpectedConditions.visibilityOf(getDirection));
		getDirection.click();
	}

}
