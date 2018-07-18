package com.automation.teststeps.internet;

import java.util.List;
import java.util.Map;

import com.automation.internet.InternetHomepage;
import com.automation.utils.Log;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InternetTestSteps {

	InternetHomepage internethomepage = new InternetHomepage();
	private Scenario scenario;

	@Given("^user should be able to login using username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_should_be_able_to_login_using_username_and_password(String username, String password)
			throws Throwable {
		internethomepage.loginWithBasicAuth(username, password);

	}

	@Given("^user logs into the internet$")
	public void user_logs_into_the_internet() throws Throwable {
		internethomepage.openInternetpage();
	}

	@When("^user goes to Challenging DOM$")
	public void user_goes_to_Challenging_DOM() throws Throwable {
		internethomepage.gotoChallengingDOM();
	}

	@Then("^user should verify address$")
	public void user_should_verify_address(List<Map<String, String>> adds) throws Throwable {
		int i = 1;
		for (Map<String, String> add : adds) {

			Log.info("");
			Log.info("------------------- " + i + " ---------------------");
			Log.info("");
			internethomepage.verifyLorem(add.get("Lorem"), i);
			Log.info("");
			Log.info("----------------------------------------");
			Log.info("");
			i++;
		}
	}

	@Then("^user Edits address for$")
	public void user_Edits_address_for(List<Map<String, String>> edits) throws Throwable {
		int j = 1;

		for (Map<String, String> edit : edits) {

			Log.info("");
			Log.info("------------------------" + j + "--------------------");
			Log.info("");

			internethomepage.editLorem(edit.get("Lorem"));

			Log.info("");
			Log.info("-------------------------------------------");
			Log.info("");
			j++;

		}

	}

	@Then("^user delete address for$")
	public void user_delete_address_for(List<Map<String, String>> deletes) throws Throwable {
		int k = 1;

		for (Map<String, String> delete : deletes) {
			Log.info("");
			Log.info("------------------------" + k + "--------------------");
			Log.info("");

			internethomepage.deleteLorem(delete.get("Lorem"));

			Log.info("");
			Log.info("-------------------------------------------");
			Log.info("");
			k++;

		}

	}

	@Given("^User open Internet page$")
	public void user_open_Internet_page() throws Throwable {
		internethomepage.openInternetpage();

	}

	@When("^User click on checkbox tab$")
	public void user_click_on_checkbox_tab() throws Throwable {
		internethomepage.gotoCheckbox();
	}

	@When("^user clicks checkbox (\\d+)$")
	public void user_clicks_checkbox(int arg) throws Throwable {
		internethomepage.clickCheckbox(arg);
	}

	@When("^user clicks all checkbox$")
	public void user_clicks_all_checkbox() throws Throwable {
		internethomepage.clickAllCheckboxes();
	}

	@When("^User goto disappering elements$")
	public void user_goto_disappering_elements() throws Throwable {
		internethomepage.clickDisapperingelements();
	}

	@Then("^User verifies Gallery tab is not visible$")
	public void user_verifies_Gallery_tab_is_not_visible() throws Throwable {
		Thread.sleep(1000);
		internethomepage.verifyGallerytabNotVisible();
		Thread.sleep(1000);
	}

	@When("^User reloads the page$")
	public void user_reloads_the_page() throws Throwable {
		internethomepage.pageReload();
		Thread.sleep(3000);
	}

	@Then("^User verifies Gallery tab is visible$")
	public void user_verifies_Gallery_tab_is_visible() throws Throwable {
		internethomepage.verifyGallerytabVisible();
	}

	@Then("^User verifies Gallery tab is visible  after reload$")
	public void user_verifies_Gallery_tab_is_visible_after_reload() throws Throwable {
		internethomepage.verifyGallerytabVisible();
	}

	@Given("^User opens Internet page$")
	public void user_opens_Internet_page() throws Throwable {
		internethomepage.openInternetpage();
	}

	@When("^User goto Drag and Drop page$")
	public void user_goto_Drag_and_Drop_page() throws Throwable {
		internethomepage.dragAndDrop();
	}

	@When("^User Drag picture A and drop in picutre B place$")
	public void user_Drag_picture_A_and_drop_in_picutre_B_place() throws Throwable {
		internethomepage.pictureA();
	}

	@Given("^User open internet page$")
	public void user_open_internet_page() throws Throwable {
		internethomepage.openInternetpage();
	}

	@When("^User goto Dropdown page$")
	public void user_goto_Dropdown_page() throws Throwable {
		internethomepage.clickDropdown();
	}

	@Then("^user select Option (\\d+)$")
	public void user_select_first_Option(int i) throws Throwable {
		internethomepage.selectOption(i);
	}

	@Then("^user select \"([^\"]*)\"$")
	public void user_select_first_Option(String i) throws Throwable {
		internethomepage.selectOption(i);
	}

	@When("^User goto Dynamic Controls page$")
	public void user_goto_Dynamic_Controls_page() throws Throwable {
		internethomepage.clickDynamicControls();
	}

	@Then("^User removes the checkbox$")
	public void user_remove_the_checkbox() throws Throwable {
		internethomepage.removeCheckbox();
	}

	@Then("^user verifies checkbox is removed$")
	public void user_verifies_checkbox_is_removed() throws Throwable {
		internethomepage.verifyCheckboxIsRemoved();
	}

	@Then("^User Add back the checbox$")
	public void user_Add_back_the_checbox() throws Throwable {
		internethomepage.addCheckbox();

	}

	@Then("^user verifies checkbox is added back$")
	public void user_verifies_checkbox_is_added_back() throws Throwable {
		internethomepage.verifyCheckboxIsAdded();
	}
}
