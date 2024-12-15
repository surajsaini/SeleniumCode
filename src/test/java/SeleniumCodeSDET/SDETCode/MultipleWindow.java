package SeleniumCodeSDET.SDETCode;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class MultipleWindow extends BaseClass {

	// icicibank.com main page data
	String URL1 = "https://www.icicibank.com/";
	String loginButtonXpath = "//button[contains(@class,'hed-dropdown')]";
	String personalLoginButtonXpath = "//ul/li/a[@title='Personal ']";

	// login button page data
	String aboutUsXpath = "//div[@id='TopAboutUs']/a";
	String customerCareXpath = "//div[@id='Top24hrCustomerCare']/a";

	// about us page data
	String rowNumberXpath = "//div[@class='section-inner-account']/div[@class='row']";
	int rowCountOnPage = 5;

	@Test
	void handleMultipleWindow() throws InterruptedException {
		driver.get(URL1);

		WebElement loginButton = driver.findElement(By.xpath(loginButtonXpath));
		WebElement personalLoginButton = driver.findElement(By.xpath(personalLoginButtonXpath));

		loginButton.click();
		personalLoginButton.click();
		String loginPageTitle = driver.getTitle();

		WebElement aboutUsLink = driver.findElement(By.xpath(aboutUsXpath));
		WebElement CustomerCareLink = driver.findElement(By.xpath(aboutUsXpath));

		aboutUsLink.click();
		CustomerCareLink.click();

		// String parentWindowId = driver.getWindowHandle();
		// System.out.println(parentWindowId);
		String workingWindow = null;
		String workingWindow2 = null;
		String workingWindowURL = "https://www.icicibank.com/about-us";

		Set<String> childWindowId = driver.getWindowHandles();
		for (String Ids : childWindowId) {
			if (driver.getTitle().equals(loginPageTitle)) {
				workingWindow = Ids;
			}
			if (driver.switchTo().window(Ids).getCurrentUrl().equals(workingWindowURL)) {
				workingWindow2 = Ids;
			}
		}

		driver.switchTo().window(workingWindow).close();
		driver.switchTo().window(workingWindow2);
		List<WebElement> rowCount = driver.findElements(By.xpath(rowNumberXpath));
		Assert.assertEquals(rowCount.size(), rowCountOnPage);
	}
}
