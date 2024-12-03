package SeleniumCodeSDET.SDETCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ChatGPTCode_1 extends BaseClass {

	// WebDriver driver;
	// WebDriverWait wait;

	@Test
	public void searchAndValidateProducts() {
		// Step 1: Open Walmart website
		driver.get("https://www.walmart.ca/en");

		// Step 2: Find the search box and enter "iPhone 16"
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("global-search-input")));
		searchBox.sendKeys("iPhone 16");
		searchBox.submit();

		// Step 3: Wait for search results to load
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".product-tile")));

		// Step 4: Collect all products and their prices
		List<WebElement> products = driver.findElements(By.cssSelector(".product-tile"));
		List<WebElement> prices = driver.findElements(By.cssSelector(".product-price__value"));

		// Validate that there are at least 4 products under $10,000
		int countUnder10000 = 0;

		for (WebElement priceElement : prices) {
			String priceText = priceElement.getText().replaceAll("[^\\d.]", ""); // Remove non-numeric characters
			if (!priceText.isEmpty()) {
				double price = Double.parseDouble(priceText);
				if (price < 10000) {
					countUnder10000++;
				}
			}
		}

		// Assertion: At least 4 products are under $10,000
		Assert.assertTrue(countUnder10000 >= 4,
				"Less than 4 products are priced under $10,000. Found: " + countUnder10000);
	}

}
