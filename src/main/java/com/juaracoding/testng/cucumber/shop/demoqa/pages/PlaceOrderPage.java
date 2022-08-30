package com.juaracoding.testng.cucumber.shop.demoqa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juaracoding.testng.cucumber.shop.demoqa.driver.DriverSingleton;

public class PlaceOrderPage {

	private WebDriver driver;
	
	public PlaceOrderPage() {
		this.driver=DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	//dress
	@FindBy(xpath="//div[@class='noo-product-item one noo-product-sm-4 not_featured post-1473 product type-product status-publish has-post-thumbnail product_cat-bodycon-dresses product_tag-bodycon-dresses product_tag-women has-featured first instock shipping-taxable purchasable product-type-variable']//div[@class='owl-item active']//img[@class='product-one-thumb']")
	private WebElement clickProduct;
	
	//shirt
	@FindBy(xpath="//div[@class='noo-product-item one noo-product-sm-4 not_featured post-1497 product type-product status-publish has-post-thumbnail product_cat-t-shirt product_tag-t-shirt product_tag-women has-featured first instock shipping-taxable purchasable product-type-variable']//div[@class='owl-item active']//img[@class='product-one-thumb']")
	private WebElement clickProductDua;
	
	@FindBy(xpath ="//select[@id='pa_color']")
	private WebElement listColor;
	
	@FindBy(xpath ="//select[@id='pa_size']")
	private WebElement listSize;
	
	//button click add to cart
	@FindBy(xpath="//button[normalize-space()='Add to cart']")
	private WebElement clickTocart;
	
	//button cart
	@FindBy(xpath="//i[@class='icon_bag_alt']")
	private WebElement btnCart;
	
	@FindBy(xpath="//a[@class='checkout-button button alt wc-forward']")
	private WebElement btnCheckout;
	
	//form cekout
	@FindBy(xpath="//input[@id='billing_first_name']")
	private WebElement firstName;
	
	@FindBy(xpath= "//input[@id='billing_last_name']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@id='billing_company']")
	private WebElement company;
	
	@FindBy(xpath="//span[@id='select2-billing_country-container']")
	private WebElement textboxCountry;
	
	@FindBy(xpath = "//input[@role='combobox']")
	private WebElement inputCountry;
	
	@FindBy(xpath="//input[@id='billing_address_1']")
	private WebElement billingAddress;
	
	@FindBy(xpath="//input[@id='billing_city']")
	private WebElement billingCity;
	
	@FindBy(xpath="//span[@id='select2-billing_state-container']")
	private WebElement textboxProvince;
	
	@FindBy(xpath = "//input[@role='combobox']")
	private WebElement inputProvince;
	
	@FindBy(xpath="//input[@id='billing_postcode']")
	private WebElement kodepos;
	
	@FindBy(xpath="//input[@id='billing_phone']")
	private WebElement telpon;
	
	@FindBy(xpath="//input[@id='billing_email']")
	private WebElement billingEmail;
	
	@FindBy(xpath="//*[@id=\"terms\"]")
	private WebElement checkboxTerms;
	
	@FindBy(xpath="//button[@id='place_order']")
	private WebElement btnPlaceorder;
	
	@FindBy(xpath = "//p[@class='woocommerce-thankyou-order-received']")
	private WebElement successOrder;
	
	
	//step
	public void clickBtnImg() {
		clickProduct.click();
	}
	
	public void clickBtnImgDua() {
		clickProductDua.click();
	}
	
	public void pilihColor(String color) {
		Select selectColor = new Select(listColor);
		selectColor.selectByVisibleText(color);
		selectColor.selectByIndex(1);
		listColor.click();
	}
	
	public void pilihSize(String ukuran) {
		Select selectSize = new Select(listSize);
		selectSize.selectByVisibleText(ukuran);
		selectSize.selectByIndex(1);
		listSize.click();		
	}
	
	//add to cart
	public void clickBtnAddToCart() {
		clickTocart.click();
	}
	
	public void clickBtnCart() {
		btnCart.click();
	}
	
	//form cekout
	public void clickBtnCheckout() {
		btnCheckout.click();
	}
	
	public void formOrder() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		this.firstName.sendKeys("Erbina");
		this.lastName.sendKeys("Selvia");
		js.executeScript("window.scrollBy(0,700)");
		this.company.sendKeys("Juara Coding");
		textboxCountry.click();
		this.inputCountry.sendKeys("Indonesia",Keys.ENTER);
		this.billingAddress.sendKeys("Jl Telekomunikasi");
		this.billingCity.sendKeys("Bandung");
		textboxProvince.click();
		this.inputProvince.sendKeys("Jawa Barat",Keys.ENTER);
		this.kodepos.sendKeys("40111");
		this.telpon.sendKeys("081260911459");
	}
	
	public void clickTerm() {
		delay(2);
		checkboxTerms.click();
	}
	
	public void placeOrder() {
		btnPlaceorder.click();
	}
	
	public String getTxtSuksesOrder() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		return successOrder.getText();
	}
	
	
	static void delay(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
