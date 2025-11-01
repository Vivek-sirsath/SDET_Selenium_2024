
// frameToBeAvailableAndSwitchToIt(): This method is used to wait until the element to be located gets converted to a frame.

package explicitWaitAndMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameToBeAvailableAndSwitchToIt {

	public static void main(String[] args) throws InterruptedException {

		    WebDriverManager.chromedriver().setup();
		    WebDriver driver = new ChromeDriver();
	        driver.get("https://the-internet.herokuapp.com/iframe");

	        // Wait for the iframe and switch to it
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("mce_0_ifr")));

	        // Now locate the <body> tag inside the editor
	        WebElement editor = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

	        // Clear the text: use Ctrl+A + Backspace
	        editor.sendKeys(Keys.CONTROL + "a");  // select all
	        editor.sendKeys(Keys.BACK_SPACE);     // delete

	        // Type new content
	        editor.sendKeys("Hello from Selenium!");

	        // Switch back to the main content
	        driver.switchTo().defaultContent();

	        // Optional: wait a bit to see result before quitting
	        try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        driver.quit();
	}

}
