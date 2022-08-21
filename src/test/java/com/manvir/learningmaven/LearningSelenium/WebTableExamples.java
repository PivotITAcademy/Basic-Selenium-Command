package com.manvir.learningmaven.LearningSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

	@BeforeMethod
	public void setUp() {
		// setting up the chrome driver path
		System.setProperty("webdriver.chrome.driver", "F:\\\\Drivers\\\\Chrome Driver\\\\chromedriver.exe");

		// Creating Ref. variable and intialising with Chrome driver
		webDriver = new ChromeDriver();
		
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Get the URL of the page0
		webDriver.get("https://www.w3schools.com/html/html_tables.asp");

		// Maximise the browser
		webDriver.manage().window().maximize();

	}

	@Test
	public void webTableTest1() {
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

	@Test
	public void webTableTest2() {
		WebElement element = getCellFromCustomerTable("Island Trading", Table_example.CONTACT);
		System.out.println(element.getText());
		
		WebElement element1 = getCellFromCustomerTable("Centro comercial Moctezuma", Table_example.COMPANY);
		System.out.println(element1.getText());
		
		WebElement element2 = getCellFromCustomerTable("Magazzini Alimentari Riuniti", Table_example.CONTACT);
		System.out.println(element2.getText());
	}

	@AfterMethod
	public void tearDown() {
		webDriver.quit();
	}

	public WebElement getCellFromCustomerTable(String companyName, Table_example column) {

		int columnIndex = getIndexForColumn(column);
		int companyColumnIndex = getIndexForColumn(Table_example.COMPANY);

		if (columnIndex < 0) {
			return null;
		}

		List<WebElement> rows = webDriver.findElements(By.cssSelector("table[class='ws-table-all'] tr"));

		for (int i = 1; i < rows.size(); i++) {
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			if (cells.size() < columnIndex || cells.size() < companyColumnIndex) {
				continue;
			}
			String[] devicesIds = cells.get(companyColumnIndex).getText().split("\n");
			for (int j = 0; j < devicesIds.length; j++) {
				if (devicesIds[j].equals(companyName)) {
					return cells.get(columnIndex);
				}
			}

		}

		System.out.println(String.format("Can't find row, which contains Company name = %s", companyName));

		return null;

	}

	private int getIndexForColumn(Table_example column) {
		List<WebElement> headers = null;

		headers = webDriver.findElements(By.cssSelector("table[class='ws-table-all'] tr th"));
		for (WebElement header : headers) {
			if (column.getText().equals(header.getText())) {
				return headers.indexOf(header);

			}
		}

		return -1;
	}

	public enum Table_example {
		COMPANY("Company"), 
		CONTACT("Contact"), 
		COUNTRY("Country");

		private String value;

		Table_example(String value) {
			this.value = value;
		}

		public String getText() {
			return value;
		}

	}
}
