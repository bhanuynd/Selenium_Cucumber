package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration; // Import from java.time

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	protected static WebDriver driver;
	protected static WebDriverWait wait;

	public static void selectDriver(String browser) {
		if (browser.equals("chrome")) {
			launchChromeDriver();
		}
		if (browser.equals("firefox")) {
			launchFirefoxDriver();
		}
		if(browser.equals("IE")) {
			launchIEDriver();
		}
	}
	
	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void launchChromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		initializeWait();
	}

	public static void launchFirefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		initializeWait();
	}
	public static void launchIEDriver() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		initializeWait();
	}
	private static void initializeWait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	public static WebDriver getDriver() {
        return driver;
    }
	
	public void click(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public void enterText(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(text);
	}
	
}
