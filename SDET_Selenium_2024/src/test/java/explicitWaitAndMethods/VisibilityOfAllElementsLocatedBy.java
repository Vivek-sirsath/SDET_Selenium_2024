
// Visibility of all elements Located by- It checks whether all elements of a web page which are located by locator is visible or not

package explicitWaitAndMethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VisibilityOfAllElementsLocatedBy {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/buttons");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			List<WebElement> buttons = wait
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".btn-primary")));

			System.out.println("✅ Buttons visible: " + buttons.size());

			for (WebElement button : buttons) {
				System.out.println("Button Text: " + button.getText());
			}

		} catch (TimeoutException e) {
			System.out.println("❌ Timeout: Buttons not found or not visible.");
		} finally {
			driver.quit();
		}

	}
}
