package SeleniumJavaTipsAndTricks2024;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlertsWithoutUsingSwitchToMethods {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

		driver.findElement(By.xpath("//button[@id='alertBtn']")).click();
		
		// 1st WAY 
		/*
		 * Alert al = driver.switchTo().alert(); 
		 * al.accept();
		 * 
		 * // 2nd Way - Using Explicit Wait 
		 * WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(10)); 
		 * Alert alert = wt.until(ExpectedConditions.alertIsPresent()); 
		 * alert.accept();
		 */
		// 3rd way - Using JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		try {
			js.executeScript("window.alert = function{};");
		} catch (Exception e) {
			System.out.println("Error Message: " + e.getMessage());
		}
        System.out.println("Alert handeled");
	}

}
