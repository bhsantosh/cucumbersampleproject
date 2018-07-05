package com.automation.teststeps;

import java.util.List;
import java.util.Map;

import com.automation.mainpage.HomePage;
import com.automation.utils.Log;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
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
	@Given("^user tries to book a Hotel room in PHPtravels$")
	public void user_tries_to_book_a_Hotel_room_in_PHPtravels() throws Throwable {
		homepage.openHotwire();
		homepage.gotohoteltab();
	    
	}

	@When("^user selects follow data$")
	public void user_selects_follow_data(List<Map<String, String>> values) throws Throwable {
	    for(int i =0; i < values.size(); i++){
	    	String cityname = values.get(i).get("City Name");
		    String checkin = values.get(i).get("Check In");
		    String checkout = values.get(i).get("Check out");
		    String no = values.get(i).get("no of guest");
		    
		    Log.info("-------------------------------------------");
		    Log.info("-------------->>>>>>> "  + cityname);
		    Log.info("-------------->>>>>>> "  + checkin);
		    Log.info("-------------->>>>>>> "  + checkout);
		    Log.info("-------------->>>>>>> "  + no);
		    Log.info("-------------------------------------------");
		    
		    homepage.cityName(cityname);
		    homepage.checkIn(checkin);
		    homepage.checkout(checkout);
		    homepage.guest(no);
		   
	
		    
	    }
		
		
		
	}
	
	@When("^user select hotel name \"([^\"]*)\"$")
	public void user_select_hotel_name(String arg1) throws Throwable {
	    homepage.cityName(arg1);
	}

	@When("^user select check in date \"([^\"]*)\"$")
	public void user_select_check_in_date(String arg1) throws Throwable {
	    homepage.checkIn(arg1);
	}

	@When("^user select check out date \"([^\"]*)\"$")
	public void user_select_check_out_date(String arg1) throws Throwable {
	    homepage.checkout(arg1);
	}
	
	@When("^user select no of guest as \"([^\"]*)\"$")
	public void user_select_no_of_guest_as(String arg1) throws Throwable {
	    homepage.guest(arg1);
	}

	@Then("^Click on Search tab$")
	public void click_on_Search_tab() throws Throwable {
		 homepage.hotelSearch();
	}

}
