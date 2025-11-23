package explicitWaitAndMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StalenessOf {

	public static void main(String[] args) {
		
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Get the checkbox element before it’s removed
        WebElement checkbox = driver.findElement(By.id("checkbox"));

        // Click the Remove button to delete the checkbox from DOM
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        // Wait until the checkbox is no longer attached to the DOM
        boolean isGone = wait.until(ExpectedConditions.stalenessOf(checkbox));

        if (isGone) {
            System.out.println("✅ Checkbox element is now stale (removed from DOM).");
        } else {
            System.out.println("❌ Checkbox is still attached to the DOM.");
        }

        driver.quit();

	}

}
