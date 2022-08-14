package com.manvir.learningmaven.LearningSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WaitExample {
	WebDriver driver;
	// instantiate the action class
	Actions ac;

	@BeforeMethod
	public void setup() {

		// Basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\Chrome Driver\\chromedriver.exe");

		// Edge driver setup : System.setProperty("webdriver.edge.driver",
		// "F:\\Drivers\\Edge Driver\\msedgedriver.exe");

		// Open up the Chrome Browser
		driver = new ChromeDriver();

		ac = new Actions(driver);

		// Opens up the Edge browser
		// driver = new EdgeDriver();

		// Load a URL on the browser than was opened.
		driver.get("https://demoqa.com/login");
		// Page load time out
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		// maxmise the screen
		driver.manage().window().maximize();
		/*
		 * // implicitly wait driver.manage().timeouts().implicitlyWait(10,
		 * TimeUnit.SECONDS); // Script time out
		 * driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
		 */

	}

	@Test()
	public void loginTest() throws InterruptedException {
		WebElement userName = driver.findElement(By.id("userName"));
		WebElement password = driver.findElement(By.id("password"));
		userName.sendKeys("pivot08062022");
		password.sendKeys("Manvir@1988");
		driver.findElement(By.id("login")).click();

		// Element is present on another page
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement xyz=driver.findElement(By.cssSelector("s"));
		
		WebElement loggedInUsername = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName-value")));
		
		
		wait.until(ExpectedConditions.alertIsPresent()).accept();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("hdgdjsfs")));
		
		//wait.until(ExpectedConditions.)

		// WebElement loggedInUsername = driver.findElement(By.id("userName-value"));
		System.out.println(loggedInUsername.getText());

	}

	@AfterMethod
	public void tearDown() {
		// Close the browser
		driver.close();
	}

	public void sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
