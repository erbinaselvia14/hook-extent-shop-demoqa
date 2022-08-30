package com.juaracoding.testng.cucumber.shop.demoqa.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", 
				features = {"src/test/resources/features/01.Login.feature",
						"src/test/resources/features/02.Checkout.feature"},
				glue = "com.juaracoding.testng.cucumber.shop.demoqa.cucumber",
				plugin = {"pretty","html:target/cucumber-reports.html","json:target/cucumber.json"})
public class TestRunner extends AbstractTestNGCucumberTests{

}
