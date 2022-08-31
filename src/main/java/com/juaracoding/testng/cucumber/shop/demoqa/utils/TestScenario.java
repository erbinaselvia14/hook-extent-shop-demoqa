package com.juaracoding.testng.cucumber.shop.demoqa.utils;

public enum TestScenario {

	T1("User valid Login"),
	T2("user check out item");
	
	private String testName;
	
	TestScenario(String value) {
		testName = value;
	}
	
	public String getTestName() {
		return testName;
	}
}
