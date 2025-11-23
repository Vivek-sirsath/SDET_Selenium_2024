package explicitWaitAndMethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PresenceOfAllElementsLocated {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-handling-waits/");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		List<WebElement> group = driver.findElements(By.tagName("input"));

		System.out.println("No of links present:- " + group.size()); // 2

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(3000);

		for (int i = 0; i < group.size(); i++) {
			System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("input"))).isEnabled()); // 2 times 'true'
		}

	}
}
