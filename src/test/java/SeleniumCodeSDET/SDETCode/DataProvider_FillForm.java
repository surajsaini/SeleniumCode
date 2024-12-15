package SeleniumCodeSDET.SDETCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_FillForm extends BaseClass {

	@DataProvider(name = "userData")
	public Object[][] provideData() {
		return new Object[][] { 
		     	{ "John", "Doe", "john.doe@example.com" },
				{ "Jane", "Smith", "jane.smith@example.com" }, 
				{ "Mike", "Johnson", "mike.johnson@example.com" } 
				              };
	}

	@Test(dataProvider = "userData")
	void fillform(String firstName, String lastName, String email) throws InterruptedException{

		// form main page
		String firstNameXpath = "//input[@type='text' and @name='input_1.3']";
		String secondNameXpath = "//input[@type='text' and @name='input_1.6']";
		String emailXpath = "//input[@type='email' and @name='input_3']";
		String submitButtonXpath = "//input[@type='submit' and @class='gform_button button']";

		driver.get("https://sequoiaco.ca/contact/");

		driver.findElement(By.xpath(firstNameXpath)).sendKeys(firstName);
		driver.findElement(By.xpath(secondNameXpath)).sendKeys(lastName);
		driver.findElement(By.xpath(emailXpath)).sendKeys(email);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0, 1000);");
		

		driver.findElement(By.xpath(submitButtonXpath)).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement confirmationMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("gform_confirmation_message_1")));
		String conMessage = confirmationMessage.getText();
		Assert.assertEquals(conMessage, "Thanks for contacting us! We will get in touch with you shortly.");

	}

}
