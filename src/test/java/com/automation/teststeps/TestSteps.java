package com.automation.teststeps;

import com.automation.mainpage.HomePage;

import cucumber.api.java.en.Given;

public class TestSteps {
	
	HomePage homepage = new HomePage();
	
	@Given("^user opens hotwire page$")
	public void user_opens_hotwire_page() throws Throwable {
	    homepage.openHotwire();
	}

}
