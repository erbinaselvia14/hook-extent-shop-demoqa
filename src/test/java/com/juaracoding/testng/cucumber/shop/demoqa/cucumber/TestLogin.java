package com.juaracoding.testng.cucumber.shop.demoqa.cucumber;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.juaracoding.testng.cucumber.shop.demoqa.driver.DriverSingleton;
import com.juaracoding.testng.cucumber.shop.demoqa.pages.LoginPage;
import com.juaracoding.testng.cucumber.shop.demoqa.utils.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestLogin {

	public static WebDriver driver;
	private static ExtentTest extentTest;
	private LoginPage loginPage = new LoginPage();
	
	public TestLogin() {
		driver = Hooks.driver;
		extentTest = Hooks.extentTest;
	}
	
	@When("user go to login page")
	public void user_go_to_login_page() {
		driver=DriverSingleton.getDriver();
		driver.get(Constants.LOGINURL);
		extentTest.log(LogStatus.PASS, "user go to login page");
	}
	
	@And("user enter username and password")
	public void user_enter_username_and_password() {
		scroll(500);
		loginPage.login("selvia14", "Erbina@14");
		extentTest.log(LogStatus.PASS, "user enter username and password");
	}
	
	@And("user click button login")
	public void user_click_button_login() {
		loginPage.clickLogin();
		extentTest.log(LogStatus.PASS, "user click button login");
	}
	
	@Then("go to page valid login")
	public void go_to_page_valid_login() {
		scroll(400);
		System.out.println(loginPage.validasiLogin());
		extentTest.log(LogStatus.PASS, "go to page valid login");
	}
	
	static void scroll(int vertical) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+vertical+")");
	}
	
}
