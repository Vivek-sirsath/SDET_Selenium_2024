package explicitWaitAndMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PresenceOfElementLocated {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-handling-waits/");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		WebElement link = driver.findElement(By.xpath("//a[contains(text(),'Click me to enable the below button')]"));

		Actions act = new Actions(driver);
		act.moveToElement(link).click().perform();
		System.out.println("Button enabling link clicked...");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(3000);

		WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='submit']")));
		System.out.println("Text on button:- " + btn.getText()); // SUBMIT

		driver.close();

	}
}
