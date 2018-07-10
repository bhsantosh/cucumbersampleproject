package com.automation.teststeps;

import java.util.List;
import java.util.Map;

import com.automation.mainpage.HomePage;
import com.automation.mainpage.HomePageFlight;
import com.automation.utils.Log;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps {

	HomePage homepage = new HomePage();
	HomePageFlight flight = new HomePageFlight();
	
	private Scenario scenario;

	@Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

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
		homepage.enterPickupDate(date, time);

	}

	@When("^user enter Return-up date as \"([^\"]*)\" at \"([^\"]*)\"$")
	public void user_enter_Return_up_date_as_at(String date, String time) throws Throwable {
		homepage.enterDropoffLocation(date, time);
	}

	@When("^user select Search tab$")
	public void user_select_Search_tab() throws Throwable {
		homepage.enterSearch();

		/*
		 * 
		 * Hotel booking test steps
		 * 
		 */

	}

	@Given("^user tries to book a Hotel room in PHPtravels$")
	public void user_tries_to_book_a_Hotel_room_in_PHPtravels() throws Throwable {
		homepage.openHotwire();
		homepage.gotohoteltab();

	}

	@When("^user selects follow data$")
	public void user_selects_follow_data(List<Map<String, String>> values) throws Throwable {
		for (int i = 0; i < values.size(); i++) {
			String cityname = values.get(i).get("City Name");
			String checkin = values.get(i).get("Check In");
			String checkout = values.get(i).get("Check out");
			String no = values.get(i).get("no of guest");

			Log.info("-------------------------------------------");
			Log.info("-------------->>>>>>> " + cityname);
			Log.info("-------------->>>>>>> " + checkin);
			Log.info("-------------->>>>>>> " + checkout);
			Log.info("-------------->>>>>>> " + no);
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
	/*
	 * 
	 * 
	 * Test steps for Flight booking Round trip using as
	 */
	 
	 

	@Given("^User opens PHPtravels page and tried to book a fight$")
	public void user_opens_PHPtravels_page_and_tried_to_book_a_fight() throws Throwable {
		flight.openHotwire();
		flight.gotoflighttab();

	}

	@When("^User select round trip$")
	public void user_select_round_trip_radio_button() throws Throwable {
		flight.roundtrip();
	}

	@When("^user select Flight class as \"([^\"]*)\"$")
	public void user_select_Flight_class_as(String cal) throws Throwable {
		flight.verifyFlightClassDropdown();
		flight.selectFlightClass(cal);
	}

	@When("^User enter fligth originating City or Airport as \"([^\"]*)\"$")
	public void user_enter_fligth_originating_City_or_Airport_as(String airport) throws Throwable {
		flight.orgairport(airport);

	}

	@When("^User enter destination city or Airport name as \"([^\"]*)\"$")
	public void user_enter_destination_city_or_Airport_name_as(String desairport) throws Throwable {
		flight.desAirportName(desairport);

	}

	@When("^User enter Departing date as \"([^\"]*)\"$")
	public void user_enter_Departing_date_as(String deptdate) throws Throwable {
		flight.departingDate(deptdate);

	}

	@When("^User enter Returning date as \"([^\"]*)\"$")
	public void user_enter_Returning_date_as(String returndates) throws Throwable {
		flight.returnDate(returndates);

	}

	@When("^User enter no of Guest as (\\d+) Adults?, (\\d+) Childs? and (\\d+) infants?$")
	public void user_enter_no_of_Guest_as_Adults_Childs_and_infants(int adult, int child, int infant) throws Throwable {

		flight.enterNoOfGuest(adult, child, infant);

	}

	@Then("^Click on search Tab$")
	public void click_on_search_Tab() throws Throwable {
		flight.flightSearch();

	}
	
	@When("^user enter following details$")
	public void user_enter_following_details(List<Map<String,String>> Value) throws Throwable {
	    for(int i = 0 ; i< Value.size();i++){
	    	
	    	String fligthclass = Value.get(i).get("Fight class");
	    	String CityName = Value.get(i).get("City Name");
	    	String DestinationCity = Value.get(i).get("Destination City");
	    	String Departingdate = Value.get(i).get("Departing date");
	    	String Returningdate = Value.get(i).get("Returning date");
	    	String Noofguests = Value.get(i).get("No of guests" );
	    	
	    	Log.info("-++++++++++++++++++++++++++++++++++++++++++++++");
	    	Log.info("fligth class is ::"+fligthclass);
	    	Log.info("City name from :::"+ CityName);
	    	Log.info("Destination city name "+ DestinationCity);
	    	Log.info("Returning city name  ::"+ Returningdate);
	    	Log.info("No of guests :::"+ Noofguests);
	    	Log.info("++++++++++++++++++++++++++++++++++++++++++++++++");
	    	
	    	flight.selectFlightClass(fligthclass);
	    	flight.orgairport(CityName);
	    	flight.desAirportName(DestinationCity);
	    	flight.departingDate(Departingdate);
	    	flight.returnDate(Returningdate);
	    	flight.enterNoOfGuest(Noofguests);
	    	
	    	
	    	
	    }
	}
	
	// third scenario for DATA driven testing
	
	
	@When("^user select Flight class  \"([^\"]*)\"$")
	public void user_select_Flight_class(String arg1) throws Throwable {
		flight.selectFlightClass(arg1);
	    
	}

	@When("^User enter fligth originating City or Airport \"([^\"]*)\"$")
	public void user_enter_fligth_originating_City_or_Airport(String arg1) throws Throwable {
		flight.orgairport(arg1);

	}

	@When("^User enter destination city or Airport name \"([^\"]*)\"$")
	public void user_enter_destination_city_or_Airport_name(String arg1) throws Throwable {
		flight.desAirportName(arg1);

	}

	@When("^User enter Departing date \"([^\"]*)\"$")
	public void user_enter_Departing_date(String arg1) throws Throwable {
		flight.departingDate(arg1);

	}

	@When("^User enter Returning date \"([^\"]*)\"$")
	public void user_enter_Returning_date(String arg1) throws Throwable {
		flight.returnDate(arg1);

	}

	@When("^User enter no of Guest as (\\d+) Adults, (\\d+) Childs and (\\d+) infant\"([^\"]*)\"$")
	public void user_enter_no_of_Guest_as_Adults_Childs_and_infant(int arg1, int arg2, int arg3, String arg4) throws Throwable {
		flight.enterNoOfGuest(arg1,arg2,arg3);

	}   

	}

