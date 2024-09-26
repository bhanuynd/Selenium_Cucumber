package pages;

import org.openqa.selenium.WebDriver;

import base.BaseClass;
import elements.loginPageElements;

public class loginPage extends BaseClass {

	WebDriver driver;

	public loginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUserName() {
		this.enterText(driver.findElement(loginPageElements.username), "Admin");
	}

	public void enterPassword() {
		this.enterText(driver.findElement(loginPageElements.password), "admin123");
	}

	public void clickLoginButton() {
		
		this.click(driver.findElement(loginPageElements.loginButton));
	}

}
