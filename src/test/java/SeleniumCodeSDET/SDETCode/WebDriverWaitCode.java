package SeleniumCodeSDET.SDETCode;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WebDriverWaitCode extends BaseClass {

	// simple alert data for @test 1
	String timerAlertButton = "//button[@id='timerAlertButton']";
	String URL2 = "https://demoqa.com/alerts";

	@Test(enabled = true, groups = { "" }) //1
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

}
