package SeleniumCodeSDET.SDETCode;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DataProviderTest extends BaseClass {

	@Test
	void dataProviderIRCTC() throws InterruptedException {

		// IRCTC search page
		String URL1 = "https://www.irctc.co.in/nget/train-search";
		String fromTextBoxXpath = "//p-autocomplete[@id='origin']";
		String toTextBoxXpath = "//p-autocomplete[@id='destination']";
		String dateTextBoxXpath = "//p-calendar[@id='jDate']";
		String classTextBoxXpath = "//p-dropdown[@id='journeyClass']";
		String classSelectionXpath = "Sleeper";
		String tickBoxXpath = "//label[text()='Flexible With Date']";

		driver.get(URL1);

		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	//	WebElement fromTextBox = driver.findElement(By.xpath(fromTextBoxXpath));
		WebElement toTextBox = driver.findElement(By.xpath(toTextBoxXpath));
		WebElement dateTextBox = driver.findElement(By.xpath(dateTextBoxXpath));
		WebElement tickBox = driver.findElement(By.xpath(tickBoxXpath));

		 WebElement fromTextBox =
		wait.until(ExpectedConditions.elementToBeClickable(By.id("origin")));
		 
		 Actions actions = new Actions(driver);
	        actions.moveToElement(fromTextBox).click().sendKeys("Delhi").perform();

	//	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		// Send keys using JavaScript
	//	jsExecutor.executeScript("arguments[0].value='New Delhi';", fromTextBox);
		Thread.sleep(10000);

		// driver.findElement(By.id("origin")).sendKeys("New Delhi");
		// fromTextBox.click();
		// fromTextBox.sendKeys("Delhi");
		// fromTextBox.sendKeys(Keys.TAB);

		toTextBox.sendKeys("Amritsar");
		toTextBox.sendKeys(Keys.TAB);

		dateTextBox.sendKeys("17/12/2024");

		tickBox.clear();
		tickBox.click();

		WebElement classTextBox = driver.findElement(By.xpath(classTextBoxXpath));
		classTextBox.click();
		WebElement classSelection = driver.findElement(
				By.xpath(classTextBoxXpath + "//li//span[contains(text(),'" + classSelectionXpath + "')]"));

		classSelection.click();

		Thread.sleep(10000);

	}

}
