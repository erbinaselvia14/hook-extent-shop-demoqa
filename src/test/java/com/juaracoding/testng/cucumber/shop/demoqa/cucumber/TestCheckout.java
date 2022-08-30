package com.juaracoding.testng.cucumber.shop.demoqa.cucumber;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.juaracoding.testng.cucumber.shop.demoqa.driver.DriverSingleton;
import com.juaracoding.testng.cucumber.shop.demoqa.pages.LoginPage;
import com.juaracoding.testng.cucumber.shop.demoqa.pages.PlaceOrderPage;
import com.juaracoding.testng.cucumber.shop.demoqa.pages.SearchPage;
import com.juaracoding.testng.cucumber.shop.demoqa.utils.Constants;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestCheckout {

	public static WebDriver driver;
	private LoginPage loginPage = new LoginPage();
	private SearchPage searchPage = new SearchPage();
	private PlaceOrderPage placeOrderPage= new PlaceOrderPage();
	
	public TestCheckout() {
		driver=Hooks.driver;
	}
	
	@When("search dress item")
	public void search_dress_item() {
		driver=DriverSingleton.getDriver();
		driver.get(Constants.LOGINURL);
		scroll(500);
		loginPage.login("selvia14", "Erbina@14");
		loginPage.clickLogin();
		scroll(400);
		System.out.println(loginPage.validasiLogin());
		searchPage.btnDashboard();
		searchPage.btnSearch();
		System.out.println(searchPage.getTittleSearch());
		searchPage.searchItem("dress");
		scroll(400);
		System.out.println(searchPage.getTxtResult());
	}
	
	@And("add dress item")
	public void add_dress_item() {
		placeOrderPage.clickBtnImg();
		scroll(800);
		placeOrderPage.pilihColor("White");
		placeOrderPage.pilihSize("Medium");
		placeOrderPage.clickBtnAddToCart();
	}
	
	@And("search shirt item")
	public void search_shirt_item() {
		searchPage.btnSearch();
		System.out.println(searchPage.getTittleSearch());
		searchPage.searchItem("shirt");
		scroll(400);
		System.out.println(searchPage.getTxtResultDua());
	}
	
	@And("add shirt item")
	public void add_shirt_item() {
		placeOrderPage.clickBtnImgDua();
		scroll(800);
		placeOrderPage.pilihColor("Pink");
		placeOrderPage.pilihSize("36");
		placeOrderPage.clickBtnAddToCart();
	}
	
	@And("user filling billing")
	public void user_filling_billing() {
		placeOrderPage.clickBtnCart();
		scroll(900);
		placeOrderPage.clickBtnCheckout();
		scroll(400);
		placeOrderPage.formOrder();
		placeOrderPage.clickTerm();
	}
	
	@And("user place order")
	public void user_place_order() {
		placeOrderPage.placeOrder();
	}
	
	@Then("validate valid scenario")
	public void validate_valid_scenario() {
		placeOrderPage.getTxtSuksesOrder();
	}
	
	static void scroll(int vertical) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+vertical+")");
	}
}
