package com.manvir.learningmaven.LearningSelenium;

import java.util.List;
import java.util.Set;
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

public class FindElementsExample {

	WebDriver driver;
	// instantiate the action class
	Actions ac;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		ac = new Actions(driver);
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	@Test()
	public void findElementsExample() {

		// Most Important- Identify the parent tab
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println(parentWindowHandle);

		driver.findElement(By.id("tabButton")).click();
		Set<String> handles = driver.getWindowHandles();

		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindowHandle)) {
				driver.switchTo().window(windowHandle);
			}
		}

		String textFromNewTab = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(textFromNewTab);

		// Switch Back to Parent Window
		driver.switchTo().window(parentWindowHandle);
		sleep();
		driver.findElement(By.id("tabButton")).click();

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
