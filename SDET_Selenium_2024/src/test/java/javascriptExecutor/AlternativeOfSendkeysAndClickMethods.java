package javascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlternativeOfSendkeysAndClickMethods {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		// Zoom Out to 50 %
		jse.executeScript("document.body.style.zoom='70%'");
		Thread.sleep(5000);

		// Alternative of sendkeys() method
		WebElement nameInputBox = driver.findElement(By.xpath("//input[@id='name']"));
		jse.executeScript("arguments[0].setAttribute('value', 'John')", nameInputBox);
		System.out.println("Name entered");

		// Alternative of click() method
		WebElement maleRadioBtn = driver.findElement(By.xpath("//input[@id='male']"));
		jse.executeScript("arguments[0].click()", maleRadioBtn);
		System.out.println("Male radio button selected");

	}

}
