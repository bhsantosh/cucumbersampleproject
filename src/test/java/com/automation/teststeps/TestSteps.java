package com.automation.teststeps;

import com.automation.mainpage.HomePage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class TestSteps {
	
	HomePage homepage = new HomePage();
	
	@Given("^user opens hotwire page$")
	public void user_opens_hotwire_page() throws Throwable {
	    homepage.openHotwire();
	}
	
	@Given("^user tries to book a car in PHPtravels$")
	public void user_tries_to_book_a_car_in_PHPtravels() throws Throwable {
		homepage.openHotwire();
		homepage.gotoCarTab();
	}

	@When("^user enter Pick-up location as \"([^\"]*)\"$")
	public void user_enter_Pick_up_location_as(String loc) throws Throwable {
	    homepage.enterPickupLocation(loc);
	}
	
	@When("^user enter drop-off location as \"([^\"]*)\"$")
	public void user_enter_drop_off_location_as(String loc) throws Throwable {
		homepage.enterDropoffLocation(loc);
	}

	@When("^user enter Pick-up date as \"([^\"]*)\" at (\\d+) PM$")
	public void user_enter_Pick_up_date_as_at_PM(String arg1, int arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^user enter Return-up date as \"([^\"]*)\" AT (\\d+) PM$")
	public void user_enter_Return_up_date_as_AT_PM(String arg1, int arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^user select Find a Car tab$")
	public void user_select_Find_a_Car_tab() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
