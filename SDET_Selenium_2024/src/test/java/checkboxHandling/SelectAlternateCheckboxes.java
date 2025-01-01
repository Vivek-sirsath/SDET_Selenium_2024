package checkboxHandling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectAlternateCheckboxes {
	public static void main(String[] args) {
//        // Set the path to your WebDriver executable
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

		// Initialize the WebDriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Navigate to the webpage with the checkboxes
		driver.get("https://testautomationpractice.blogspot.com/");

		try {

			// Locate all weekday checkboxes (adjust the locator as needed)
			List<WebElement> checkboxes = driver
					.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox'] "));

			// Loop through the checkboxes and select alternate ones
			for (int i = 0; i < checkboxes.size(); i++) {
				if (i % 2 == 0) { // Select even-indexed checkboxes (0, 2, 4, ...)
					// To start with second check box - (i % 2 != 0) OR (i % 2 == 1)
					WebElement checkbox = checkboxes.get(i);
					if (!checkbox.isSelected()) {
						checkbox.click();
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		driver.close();
	}

}
