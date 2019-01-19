package com.automation.teststeps.php;

import java.util.List;
import java.util.Map;

import com.automation.php.Flight;
import com.automation.php.HomePage;
import com.automation.php.Tours;
import com.automation.php.Visa;
import com.automation.utils.Log;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps {

	HomePage homepage = new HomePage();
	Flight flight = new Flight();
	Visa visa = new Visa();
	Tours tour =  new Tours();
//	ToursPratik tourPratik = new ToursPratik();
	
	private Scenario scenario;

	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}

	@Given("^user opens hotwire page$")
	public void user_opens_hotwire_page() throws Throwable {
		homepage.openPHPTravels();
	}

	@Then("^user tries to book a car in PHPtravels$")
	public void user_tries_to_book_a_car_in_PHPtravels() throws Throwable {
		homepage.openPHPTravels();
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
	}

	@When("^user select Search in visa tab$")
	public void user_select_Search_in_visa_tab() throws Throwable {
		visa.enterSearch();
	}

	@Given("^user tries to book a Hotel room in PHPtravels$")
	public void user_tries_to_book_a_Hotel_room_in_PHPtravels() throws Throwable {
		homepage.openPHPTravels();
		homepage.gotohoteltab();

	}

	@When("^user selects following visa details$")
	public void user_selects_following_visa_details(List<Map<String, String>> countrys) throws Throwable {
		for (int i = 0; i < countrys.size(); i++) {
			String origin = countrys.get(i).get("Origin Country");
			String distination = countrys.get(i).get("Destination Country");

			Log.info("------------------------------------------------");
			Log.highlight(origin);
			Log.highlight(distination);
			Log.info("------------------------------------------------");

			homepage.gotoVisaTab();

			visa.selectOriginCountry(origin);
			visa.selectdestinationcountry(distination);

			visa.enterSearch();
			visa.goBack();
		}

		// String origin = countrys.get(0).get("Origin Country");
		// String distination = countrys.get(0).get("Destination Country");

		// visa.selectOriginCountry(origin);
		// visa.selectdestinationcountry(distination);
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
		String url = homepage.openPHPTravels();
		scenario.write("URL :: " + url);
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
	public void user_enter_following_details(List<Map<String, String>> Value) throws Throwable {
		for (int i = 0; i < Value.size(); i++) {

			String fligthclass = Value.get(i).get("Fight class");
			String CityName = Value.get(i).get("City Name");
			String DestinationCity = Value.get(i).get("Destination City");
			String Departingdate = Value.get(i).get("Departing date");
			String Returningdate = Value.get(i).get("Returning date");
			String Noofguests = Value.get(i).get("No of guests");

			Log.info("-++++++++++++++++++++++++++++++++++++++++++++++");
			Log.info("fligth class is ::" + fligthclass);
			Log.info("City name from :::" + CityName);
			Log.info("Destination city name " + DestinationCity);
			Log.info("Returning city name  ::" + Returningdate);
			Log.info("No of guests :::" + Noofguests);
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
	public void user_enter_no_of_Guest_as_Adults_Childs_and_infant(int arg1, int arg2, int arg3, String arg4)
			throws Throwable {
		flight.enterNoOfGuest(arg1, arg2, arg3);

	}

	@Given("^user tries to book a visa in PHPtravels$")
	public void user_tries_to_book_a_visa_in_PHPtravels() throws Throwable {
		homepage.openPHPTravels();
		homepage.gotoVisaTab();
	}

	@But("^user selects origin country as \"([^\"]*)\"$")
	public void user_selects_origin_country_as(String country) throws Throwable {
		visa.selectOriginCountry(country);
	}

	@When("^user select destination country as \"([^\"]*)\"$")
	public void user_select_destination_country_as(String country) throws Throwable {
		visa.selectdestinationcountry(country);

	}

	@When("^user selects origin country \"([^\"]*)\"$")
	public void user_selects_origin_country(String country) throws Throwable {
		visa.selectOriginCountry(country);
	}

	@When("^user selects destination country \"([^\"]*)\"$")
	public void user_selects_destination_country(String country) throws Throwable {
		visa.selectdestinationcountry(country);

	}

	@Given("^user tries to subscribe PHPtravels$")
	public void user_tries_to_subscribe_PHPtravels() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("^user clicks subscribe button$")
	public void user_clicks_subscribe_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}
	
/*	@When("^user selects City name as \"([^\"]*)\"$")
	public void user_selects_City_name_as(String arg1) throws Throwable {
	  
	}

	@When("^user selects startdate as \"([^\"]*)\"$")
	public void user_selects_startdate_as(String arg1) throws Throwable {
	   
	}

	@When("^user selects guests as \"([^\"]*)\"$")
	public void user_selects_guests_as(String arg1) throws Throwable {
	   
	}

	@When("^user selects tour type as \"([^\"]*)\"$")
	public void user_selects_tour_type_as(String arg1) throws Throwable {
	    
	}
*/
/*	@When("^user selects search in Tours page$")
	public void user_selects_search_in_Tours_page() throws Throwable {
		homepage.enterSearch(); 
	}
*/
	
	//Robin Tours
	
	@Given("^user tries to book tours$")
	public void user_tries_to_book_tours() throws Throwable {
	   homepage.openPHPTravels();
	   homepage.gotoToursTab();
	}
	
	@When("^user tries to enter cityName as \"([^\"]*)\"$")
	public void user_tries_to_enter_cityName_as(String cityname) throws Throwable {
		tour.enterCityName(cityname);
	}
	
	@When("^user selects following tour details$")
	public void user_selects_following_tour_details(List<Map<String, String>> values) throws Throwable {
	    for (int i=0; i<values.size(); i++)
	    {
	    	String tourCityName = values.get(i).get("City Name");
	    	String tourDate = values.get(i).get("Tour Date");
	    	String tourNoOfGuests=values.get(i).get("No Of Guests");
	    	String tourType=values.get(i).get("Tour Type");
	    	
	    	Log.info("-----------------------");
	    	Log.info("---"+tourCityName);
	    	Log.info("---"+tourDate);
	    	Log.info("---"+tourNoOfGuests);
	    	Log.info("---"+tourType);
	   	    	
	    	tour.enterCityName(tourCityName);
	    	tour.enterTourDate(tourDate);
	    	tour.enterTourGuests(tourNoOfGuests);
	    	tour.enterTourType(tourType);
	    	tour.clickSearch();
	    	
	    	
	    }
	}

	
//	 pratik tours
	
	/*@Given("^user tries to book a private tour in PHPtravels$")
	public void user_tries_to_book_a_private_tour_in_PHPtravels() throws Throwable {
		homepage.openPHPTravels();
		tourPratik.selectTour();
	   
	}

	@When("^user select the city as \"([^\"]*)\"$")
	public void user_select_the_city_as(String cityName) throws Throwable {
		tourPratik.selectCity(cityName);

	}

	@When("^user select the date as \"([^\"]*)\"$")
	public void user_select_the_date_as(String date) throws Throwable {
		tourPratik.tourStartDate(date);
		
	}

	@When("^user select no of Guests as \"([^\"]*)\"$")
	public void user_select_no_of_Guests_as(String number) throws Throwable {
		tourPratik.noOfGuest(number);

	}

	@When("^user select tour type as \"([^\"]*)\"$")
	public void user_select_tour_type_as(String type) throws Throwable {
		tourPratik.tourType(type);

	}

	@When("^user select Search in tours tab$")
	public void user_select_Search_in_tours_tab() throws Throwable {
		tourPratik.tourSearch();

	}*/
}
