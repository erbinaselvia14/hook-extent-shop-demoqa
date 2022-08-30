package com.juaracoding.testng.cucumber.shop.demoqa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.testng.cucumber.shop.demoqa.driver.DriverSingleton;

public class SearchPage {

	private WebDriver driver;
	
	public SearchPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='noo-search']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//a[normalize-space()='Dashboard']")
	private WebElement btnDashboard;
	
	@FindBy(xpath="//label[@class='note-search']")
	private WebElement titleSearch;
	
	@FindBy(xpath="//input[@name='s']")
	private WebElement searchInput;
	
	//dress
	@FindBy(xpath="//a[normalize-space()='white milkmaid hook and eye bodycon midi dress']")
	private WebElement txtResult;
	
	//shirt
	@FindBy(xpath="//a[normalize-space()='pink drop shoulder oversized t shirt']")
	private WebElement txtResultDua;
	
	//product kosong
	@FindBy(xpath="//p[@class='woocommerce-info']")
	private WebElement resultKosong;

	
	public void btnSearch() {
		this.searchBtn.click();
	}
	
	public void btnDashboard() {
		btnDashboard.click();
	}
	
	public String getTittleSearch() {
		return titleSearch.getText();
	}
	
	public void searchItem(String kata) {
		delay(1);
		this.searchInput.sendKeys(kata,Keys.ENTER);
	}
	
	//dress
	public String getTxtResult() {
		return txtResult.getText();
	}
	
	//shirt
	public String getTxtResultDua() {
		return txtResultDua.getText();
	}
	
	public String resultNull() {
		return resultKosong.getText();
	}
	
	static void delay(int second) {
		try {
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
