package stepDefintions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import env.BaseTest;

public class UserStepDefinitions implements BaseTest{

	//////////////
	// Identifiers
	//////////////

	//URL to application
	private static final String URL = "";

	//Login success message text
	private static final String LOGIN_SUCCESS = "";

	//Login error message text
	private static final String LOGIN_ERROR_MISSING_DATA = "";

	//Registration success message text
	private static final String REGISTRATION_SUCCESS = "";

	//Registration error message text
	private static final String REGISTRATION_ERROR_MISSING_DATA = "";

	//Finds the registration button element
	@FindBy(xpath = "")
	private WebElement registrationButton;

	//Finds the username text box displayed during registration
	@FindBy(xpath = "")
	private WebElement registrationUsernameTextBox;

	//Finds the first name text box displayed during registration
	@FindBy(xpath = "")
	private WebElement registrationFirstNameTextBox;

	//Finds the last name text box displayed during registration
	@FindBy(xpath = "")
	private WebElement registrationLastNameTextBox;

	//Finds the phone number text box displayed during registration
	@FindBy(xpath = "")
	private WebElement registrationPhoneTextBox;

	//Finds the password text box displayed during registration
	@FindBy(xpath = "")
	private WebElement registrationPasswordTextBox;

	//Finds the confirm registration button
	@FindBy(xpath = "")
	private WebElement confirmRegistrationButton;

	//Finds the username text box (used for login)
	@FindBy(xpath = "")
	private WebElement usernameTextBox;

	//Finds the password text box (used for login)
	@FindBy(xpath = "")
	private WebElement passwordTextBox;

	//Finds the login button
	@FindBy(xpath = "")
	private WebElement loginButton;

	//Finds the login button
	@FindBy(xpath = "")
	private WebElement logoutButton;

	//Finds the registration success message area
	@FindBy(xpath = "")
	private WebElement registrationSuccessMessageArea;

	//Finds the registration error message area
	@FindBy(xpath = "")
	private WebElement registrationErrorMessageArea;

	//Finds the login success message area
	@FindBy(xpath = "")
	private WebElement loginSuccessMessageArea;

	//Finds the login error message area
	@FindBy(xpath = "")
	private WebElement loginErrorMessageArea;

	//////////////
	// Navigation
	//////////////

	//Navigates to landing page
	@Given("^User is on Landing Page$")
	public void user_is_on_Landing_Page() throws Throwable {
		navigationObj.navigateTo(URL);
	}

	//Clicks the register button to navigate to registration page
	@When("^User navigates to Registration Page$")
	public void user_navigates_to_Registration_Page() throws Throwable {
		registrationButton.click();
	}

	//////////////
	// Interaction
	//////////////

	//Clicks logout
	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() throws Throwable {
		logoutButton.click();
	}

	//Clicks confirm registration button
	@When("^User clicks confirm registration button$")
	public void user_clicks_confirm_registration_button() throws Throwable {
		confirmRegistrationButton.click();
	}

	/////////////
	// Utilities
	/////////////

	//Enters registration data (from data table) -- username, first name, last name, phone, and password into respective registration text boxes
	@When("^User enters Registration Data$")
	public void user_enters_registration_data(DataTable userdata) throws Throwable {
		List<List<String>> data = userdata.raw();
		registrationUsernameTextBox.sendKeys(data.get(0).get(0));
		registrationFirstNameTextBox.sendKeys(data.get(0).get(1));
		registrationLastNameTextBox.sendKeys(data.get(0).get(2));
		registrationPhoneTextBox.sendKeys(data.get(0).get(3));
		registrationPasswordTextBox.sendKeys(data.get(0).get(4));
	}

	//Enters provided username and password into respective text boxes and clicks login
	@When("^User enters \"(.*)\" and \"(.*)\" to login$")
	public void user_enters_UserName_and_Password(String username, String password) throws Throwable {
		usernameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		loginButton.click();
	}

	//Enters credentials from data table in username and password text boxes and clicks login button
	@When("^User enters Credentials to LogIn$")
	public void user_enters_testuser__and_Test(DataTable usercredentials) throws Throwable {
		List<List<String>> data = usercredentials.raw();
		usernameTextBox.sendKeys(data.get(0).get(0));
		passwordTextBox.sendKeys(data.get(0).get(1));
		loginButton.click();
	}

	////////////////
	// Verification
	///////////////

	//Verifies login success message is displayed
	@Then("^Message displayed Login Successful$")
	public void message_displayed_Login_Successful() throws Throwable {
		Assert.assertEquals("Login success message not displayed.", LOGIN_SUCCESS, loginSuccessMessageArea.getText());
	}

	//Verifies login error message is displayed
	@Then("^Message displayed Login Error Missing Data$")
	public void message_displayed_Login_Error_Missing_Data() throws Throwable {
		Assert.assertEquals("Login error message not displayed.", LOGIN_ERROR_MISSING_DATA, loginErrorMessageArea.getText());
	}

	//Verifies registration success message is displayed
	@Then("^Message displayed Registration Successful$")
	public void message_displayed_Registration_Successful() throws Throwable {
		Assert.assertEquals("Registration success message not displayed.", REGISTRATION_SUCCESS, registrationSuccessMessageArea.getText());
	}

	//Verifies login success message is displayed
	@Then("^Message displayed Registration Error Missing Data$")
	public void message_displayed_Registration_Error_Missing_Data() throws Throwable {
		Assert.assertEquals("Registration error message not displayed.", REGISTRATION_ERROR_MISSING_DATA, registrationErrorMessageArea.getText());
	}


}
