package com.manvir.learningmaven.LearningSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTableExamples {

	WebDriver webDriver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		// setting up the chrome driver path
		System.setProperty("webdriver.chrome.driver", "F:\\\\Drivers\\\\Chrome Driver\\\\chromedriver.exe");

		// Creating Ref. variable and intialising with Chrome driver
		webDriver = new ChromeDriver();

		wait = new WebDriverWait(webDriver, 10);

		// Get the URL of the page0
		webDriver.get("https://demo.guru99.com/test/web-table-element.php");

		// Maximise the browser
		webDriver.manage().window().maximize();

	}

	@Test
	public void webTableTest() {
		int counter = 0;
		List<WebElement> noOfRows = webDriver.findElements(By.xpath("//table[@class='dataTable']//tr"));
		List<WebElement> noOfColumns = webDriver.findElements(By.xpath("//table[@class='dataTable']//tr//th"));
		System.out.println("The number of rows: " + noOfRows.size());
		System.out.println("The number of columns: " + noOfColumns.size());

		String xpathBefore = "//table[@class='dataTable']//tr[";
		String xpathAfter = "]//td[";

		for (int i = 1; i < noOfRows.size(); i++) {
			for (int j = 1; j < noOfColumns.size(); j++) {
				WebElement element = webDriver
						.findElement(By.xpath("//table[@class='dataTable']//tr[" + i + "]//td[" + j + "]"));
				if (element.getText().equals("Apollo Hospitals")) {
					element.click();
				}

			}
		}

	}

	@AfterMethod
	public void tearDown() {
		webDriver.quit();
	}
}
