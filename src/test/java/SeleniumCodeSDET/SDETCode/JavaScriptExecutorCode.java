package SeleniumCodeSDET.SDETCode;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptExecutorCode extends BaseClass{

	// simple alert data for @test 1
	String URL2 = "https://demoqa.com/alerts";
	String confirmAlertButtonXpath = "//button[@id='confirmButton']";
	String confirmAlertTextXpath = "//span[text()='Ok']";

	@Test(enabled = true, groups = { "" }) //1
	public void confirmAlert() throws InterruptedException {
		driver.get(URL2);
		WebElement confirmAlertClickButton = driver.findElement(By.xpath(confirmAlertButtonXpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmAlertClickButton);
		confirmAlertClickButton.click();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		confirmAlertClickButton.click();
		alert.accept();
		Assert.assertEquals("You selected Ok", driver.findElement(By.xpath(confirmAlertTextXpath)).getText());

	}

}
