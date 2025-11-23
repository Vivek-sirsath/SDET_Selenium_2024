package explicitWaitAndMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextToBePresentInElementValue2 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

		// Assume there's an input field that gets updated after 5 seconds
		driver.get("https://www.w3schools.com/howto/howto_js_trigger_button_enter.asp");

		// Enter some text and wait for it to appear in the value attribute
		driver.findElement(By.id("myInput")).sendKeys("Selenium Wait Test");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait until the input field's value contains the given text
		boolean textPresent = wait.until(
						ExpectedConditions.textToBePresentInElementValue(By.id("myInput"), "Selenium Wait Test"));

		if (textPresent) {
			System.out.println("Text is present in the input field.");
		} else {
			System.out.println("Text not found in the input field.");
		}

		driver.quit();
	}
}
