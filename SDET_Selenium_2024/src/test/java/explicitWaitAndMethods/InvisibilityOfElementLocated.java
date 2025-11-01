
// Invisibility Of Element Located: It checks that a specific element is either invisible or not present in the web page

package explicitWaitAndMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvisibilityOfElementLocated {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

		// Click the Start button to trigger loading
		driver.findElement(By.cssSelector("#start button")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait until the loading spinner disappears
		boolean isGone = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));

		if (isGone) {
			System.out.println("✅ Loading spinner disappeared.");

			// Now the text should be visible
			String message = driver.findElement(By.id("finish")).getText();
			System.out.println("Message: " + message);
			
		} else {
			System.out.println("❌ Spinner still visible or something went wrong.");
		}

		driver.quit();

	}
}