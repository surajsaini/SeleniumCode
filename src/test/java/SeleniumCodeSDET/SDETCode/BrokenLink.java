package SeleniumCodeSDET.SDETCode;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BrokenLink extends BaseClass {

	@Test
	public void findBrokenLink() {

		driver.get("https://www.cancapgroup.ca/");
		List<WebElement> links = driver.findElements(By.tagName("a"));

		for (WebElement hr : links) {

			String url = hr.getAttribute("href");
			// System.out.println(url);
			try {
				HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
				connection.setRequestMethod("GET");
				connection.connect();
				int responseCode = connection.getResponseCode();

				if (responseCode > 400) {
					System.out.println("broken link" + url);
				}
			} catch (Exception e) {
				System.out.println(url + " is invalid. Exception: " + e.getMessage());
			}
		}

	}

}
