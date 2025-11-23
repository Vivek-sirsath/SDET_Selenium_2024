
// Text To be Present in element: It checks the presence of text in a given element that is located through a locator.

package explicitWaitAndMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextTobePresentInElementLocated {

	public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        // Example site (use any site where a message shows dynamically)
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // Click the start button to trigger loading
        driver.findElement(By.cssSelector("#start button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the text "Hello World!" appears in the element
        Boolean isTextVisible = wait.until(
            ExpectedConditions.textToBePresentInElementLocated(By.id("finish"), "Hello World!"));

        if (isTextVisible) {
            System.out.println("✅ Text appeared: " + driver.findElement(By.id("finish")).getText());
        } else {
            System.out.println("❌ Text did not appear.");
        }

        driver.quit();
	}
}
