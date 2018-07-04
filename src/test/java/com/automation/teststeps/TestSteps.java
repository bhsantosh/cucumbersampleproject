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

	@When("^user enter Pick-up date as \"([^\"]*)\" at \"([^\"]*)\"$")
	public void user_enter_Pick_up_date_as_at(String date, String time) throws Throwable {
		homepage.enterPickupDate(date,time);
	  
	}

	@When("^user enter Return-up date as \"([^\"]*)\" at \"([^\"]*)\"$")
	public void user_enter_Return_up_date_as_at(String date, String time) throws Throwable {
	   homepage.enterDropoffLocation(date,time);
	}

	@When("^user select Search tab$")
	public void user_select_Search_tab() throws Throwable {
		homepage.enterSearch();
	   
	}

}
