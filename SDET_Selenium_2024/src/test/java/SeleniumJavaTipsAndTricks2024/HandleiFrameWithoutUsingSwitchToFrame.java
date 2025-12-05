package SeleniumJavaTipsAndTricks2024;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleiFrameWithoutUsingSwitchToFrame {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");
/*		
		// 1st WAY -  Using switchTo() method
		// Find the iFrame webelement
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		
		// Switch to iframe
		driver.switchTo().frame(frame1);
		
		// Interact with the element inside iFrame
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Selenium");
*/		
		
		// 2nd WAY - Using WebDriverWait method
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(10));
		wt.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//frame[@src='frame_1.html']")));
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Selenium");
		System.out.println("Text entered...");
		
		driver.quit();

	}

}
