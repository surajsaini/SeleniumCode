package SeleniumCodeSDET.SDETCode;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleAlerts extends BaseClass {

	// simple alert data for @test 1
	String URL1 = "https://demo.automationtesting.in/Alerts.html";
	String clickButtonXpath = "//button[@onclick='alertbox()']";

	// simple alert data for @test 2
	String dismissbutton = "//div[@id='dismiss-button']";
	String URL2 = "https://demoqa.com/alerts";
	String simpleAlertButton = "//button[@id='alertButton']";

	// simple alert data for @test 3
	String timerAlertButton = "//button[@id='timerAlertButton']";

	// confirm alert data for @test 4
	String confirmAlertButtonXpath = "//button[@id='confirmButton']";
	String confirmAlertTextXpath = "//span[text()='Ok']";

	// confirm alert data for @test 5
	String promtBoxButtonXpath = "//button[@id='promtButton']";
	String promtBoxAlertTextXpath = "//span[contains(text(),'You')]";
	String enterText = "suraj";

	@Test(enabled = false, groups = { "skipGroup" }) // 1
	public void handleAlert() {
		driver.get(URL1);
		WebElement clickbutton = driver.findElement(By.xpath(clickButtonXpath));
		clickbutton.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Test(enabled = false, groups = { "" }) // 2
	public void simpleAlert() {
		driver.get(URL2);
		WebElement simpleAlertClickButton = driver.findElement(By.xpath(simpleAlertButton));
		simpleAlertClickButton.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Test(enabled = false, groups = { "" }) // 3
	public void timerSimpleAlert() {
		driver.get(URL2);
		WebElement timerAlertClickButton = driver.findElement(By.xpath(timerAlertButton));
		timerAlertClickButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("No alert is presetn at the moment");
		}
	}

	@Test(enabled = false, groups = { "" }) // 4
	public void confirmAlert() {
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

	@Test(enabled = true, groups = { "" }) // 5
	public void promptBox() throws InterruptedException {
		driver.get(URL2);
		WebElement promtBoxAlertClickButton = driver.findElement(By.xpath(promtBoxButtonXpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", promtBoxAlertClickButton);
		promtBoxAlertClickButton.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(enterText);
		alert.accept();
		Assert.assertEquals("You entered " + enterText, driver.findElement(By.xpath(promtBoxAlertTextXpath)).getText());

	}

}
