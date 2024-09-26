package stepDefinitions;

import org.openqa.selenium.WebDriver;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.loginPage;

public class LoginPageSteps {

	loginPage loginPage;
	
	@After
	public void close() {
		BaseClass.closeDriver();
	}
	
	@Before
	public void setup() {
        // Initialize the WebDriver and navigate to the login page
    }

	@Given("User launch {string} browser and launch url")
	public void I_Launch_Browser(String browserName) {

        BaseClass.selectDriver(browserName);  // Initialize the driver
		BaseClass.launchUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User login to the application")
	public void User_Login_to_application() {

		loginPage = new loginPage(BaseClass.getDriver());
		loginPage.enterUserName();
		loginPage.enterPassword();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginPage.clickLoginButton();
	}

}
