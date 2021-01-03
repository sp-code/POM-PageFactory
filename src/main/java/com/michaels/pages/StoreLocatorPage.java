package com.michaels.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.michaels.base.Base;

public class StoreLocatorPage extends Base{

	WebDriver dr;

	By filterbtn = By.xpath("//*[@id=\"locator_search\"]/button");

	By search = By.xpath("//input[@id='search_input']");

	By storefilters = By.xpath("//div[@id='store_filters']/div/label");

	By donebtn = By.xpath("//button[@class='setFilters']");

	By checkbox2 = By.xpath("//div[@id='store_filters']/div[2]");

	By checkbox4 = By.xpath("//div[@id='store_filters']/div[3]");

	By storelist = By.xpath("//li[@class='poi-item']/div/div/div/h5");

	/* store information (SAN JOSE MARKETCENTER) */

	By store_name = By.xpath("//li[@class='poi-item']/div/div/div/h5");

	By store_link = By.xpath("//a[@class='store_link']");

	By open_days_btn = By.xpath("//button[@class='hours_toggle']");

	By all_days = By.xpath("//div[@class='hours_inner']/div/span[1]");

	/* Contact */
	By contact = By.xpath("//div[@class='static-content-leftnav']/ul/li");

	By getDirection = By.xpath("//a[@class='directions_link']");

	By storeAddress = By.xpath("//div[@class='address-wrapper']");
	
	By visit_store_page = By.xpath("//a[@class='store_link']");
	
	
	By phone = By.xpath("//a[@class='store-phone']");
	
	
	

	public StoreLocatorPage(WebDriver dr) {
		this.dr = dr;
	}

	public boolean locateFilterButton() throws InterruptedException {

		return dr.findElement(filterbtn).isDisplayed();

	}

	public ArrayList<String> verifyStoresFilter(String city) {
		ArrayList<String> al = new ArrayList<String>();

		dr.findElement(search).sendKeys(city);
		dr.findElement(filterbtn).click();

		List<WebElement> elements = dr.findElements(storefilters);
		
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));

		for (WebElement ele : elements) {
			al.add(ele.getText());
		}
		return al;

	}

	public void selectStoreFilters(String city) {
		dr.findElement(search).sendKeys(city);
		dr.findElement(filterbtn).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(checkbox2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkbox4));

		dr.findElement(checkbox2).click();
		dr.findElement(checkbox4).click();
		dr.findElement(donebtn).click();
	}

	

	
	public ArrayList<String> getStoreList() {
		ArrayList<String> storesname = new ArrayList<String>();

		wait.until(ExpectedConditions.visibilityOfElementLocated(storelist));

		List<WebElement> elements = dr.findElements(storelist);

		for (WebElement ele : elements) {
			storesname.add(ele.getText());
		}
		return storesname;

	}

	public String storeInformationName() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(store_name));

		String storeName = dr.findElement(store_name).getText();

		storeName = storeName.replaceAll("[\\d.]", "");

		storeName = storeName.trim();

		return storeName;

	}

	public String storeInformationNumber() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(phone));
		return dr.findElement(phone).getText();
		
	}

	public ArrayList<String> contactVisibility() {
		dr.switchTo().parentFrame(); // important change

		ArrayList<String> contactmenu = new ArrayList<String>();

		List<WebElement> elements = dr.findElements(contact);

		for (WebElement ele : elements) {
			contactmenu.add(ele.getText());
		}

		return contactmenu;
	}

	public ArrayList<String> openDays() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(open_days_btn));

		ArrayList<String> days = new ArrayList<String>();

		dr.findElement(open_days_btn).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(all_days));

		List<WebElement> elements = dr.findElements(all_days);

		for (WebElement ele : elements) {
			days.add(ele.getText());
		}
		return days;
	}

	public String getStoreAddress() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(storeAddress));
		String store_address = dr.findElement(storeAddress).getText();
		return store_address;
	}
	
	
	public void visitStorePage()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(visit_store_page));
		dr.findElement(visit_store_page).click();
	}

	public void getDirection() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(getDirection));
		dr.findElement(getDirection).click();
	}

}
