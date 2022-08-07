package com.manvir.learningmaven.LearningSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandleExample {

	WebDriver driver;
	// instantiate the action class
	Actions ac;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		ac = new Actions(driver);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	@Test()
	public void findElementsExample() {
		WebElement inputEmailField = driver.findElement(By.id("input-email"));
		WebElement inputPasswordField = driver.findElement(By.id("input-password"));
		WebElement loginBTN = driver.findElement(By.cssSelector("div.well form input.btn"));

		inputEmailField.sendKeys("msp@it.com");
		inputPasswordField.sendKeys("Manvir@1988");
		loginBTN.submit();

		WebElement carBtn = driver.findElement(By.id("cart"));
		carBtn.click();

		WebElement cartCheckout = driver
				.findElement(By.cssSelector("#cart ul.dropdown-menu li:last-of-type p a:nth-of-type(2) strong"));
		cartCheckout.click();
		
		List<WebElement> elements = driver.findElements(By.cssSelector("#paymen-new div:nth-of-type(1)"));

		
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	public void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
