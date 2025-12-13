/*
  - AJAX --> Asynchronous Javascript And XML 
  - AJAX call --> An AJAX call is a web development technique that allows a website to update
    parts of its content without loading the entire page.
  - It is the collection of technologies which makes the web applications more responsive to user interaction.             

*/
package SeleniumJavaTipsAndTricks2024;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingAJAXCallUsingExplicitWait {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/p/gui-elements-ajax-hidden.html");
		
		// Click on 'Load AJAX Content' button
		driver.findElement(By.id("loadContent")).click();
		
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ajaxContent = wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ajaxContent']//h2")));
		
		System.out.println(ajaxContent.getText());
		
		driver.quit();

	}

}
