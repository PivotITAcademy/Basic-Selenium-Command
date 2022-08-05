package com.manvir.learningmaven.LearningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SendKeysExample {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		// Basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\Chrome Driver\\chromedriver.exe");

		// Edge driver setup : System.setProperty("webdriver.edge.driver",
		// "F:\\Drivers\\Edge Driver\\msedgedriver.exe");

		// Open up the Chrome Browser
		driver = new ChromeDriver();

		// Opens up the Edge browser
		// driver = new EdgeDriver();

		// Load a URL on the browser than was opened.
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		// maxmise the screen
		driver.manage().window().maximize();

	}

	@Test
	public void sendKeysTest() {
		// Send information to a input text field
		WebElement firstNameInputField = driver.findElement(By.id("input-firstname"));
		firstNameInputField.sendKeys("Pivot");

		// click on a webelement
		WebElement continueBtn = driver.findElement(By.cssSelector("div.buttons input:last-of-type"));
		continueBtn.click();

		// isDisplayed
		WebElement privacyPolicyLink = driver.findElement(By.cssSelector("#account div.form-group"));
		boolean isPrivacyPolicyDisplayed = privacyPolicyLink.isDisplayed();
		System.out.println("Is privacy policy displayed: " + isPrivacyPolicyDisplayed);

		// isEnabled
		// WebElement saveBtn=driver.findElement(By.id("random"));
		// boolean isBtnEnabled=saveBtn.isEnabled();

		WebElement logo = driver.findElement(By.id("logo"));
		System.out.println(logo.isDisplayed());

		WebElement alertBanne = driver.findElement(By.cssSelector("#account-register div.alert"));
		String alertBannerText = alertBanne.getText();
		System.out.println(alertBannerText);
		Assert.assertEquals(alertBannerText, "Warning: You must agree to the Privacy Policy!", "Text does not match");

		WebElement firstErrorMessage=driver.findElement(By.cssSelector("div.has-error"));
		System.out.println(firstErrorMessage.getText());
		
		
	}

	@AfterMethod
	public void tearDown() {
		// Close the browser
		driver.close();
	}

}
