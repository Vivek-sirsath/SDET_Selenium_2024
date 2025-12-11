/*
 * Pseudo Elements : Pseudo elements are abstract elements in CSS.
 * - Allow to style specific parts of an element without adding extra HTML.
 * - Pseudo elements starts with '::'
 * - Examples of Pseudo-Elements
 *   ::first-line
 *   ::selection
 *   ::before
 *   ::after
 *   ::has 
 * 
 */

package SeleniumJavaTipsAndTricks2024;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HowToHandlePseudoElements {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://play1.automationcamp.ir/advanced");

		// Find the pseudo element
		WebElement ratingElement = driver.findElement(By.xpath("//label[@class='star-rating']"));
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String script = "return window.getComputedStyle(arguments[0],'::after').getPropertyValue('content')";
		String content = jse.executeScript(script, ratingElement).toString();
		
		/*
		   getText() returns string with double quotes as present in DOM like - "*", "**", "***"
		   To remove the double quotes use String.replace() method.
		
		   Remove double quotes
           content = content.replace("\"", "");
		
		   To remove everything except asterisk
		   content = content.replaceAll("[^*]", "");
		*/
		
		content = content.replace("\"",""); // Try comment this line to get negative response.
		
		System.out.println("Stars: " + content);
		
		// Enter the content text into input box.
		WebElement inputBox = driver.findElement(By.id("txt_rating"));
		inputBox.sendKeys(content);
		System.out.println("Actual text entered :- " + content);
		
		// Click on 'Check Rating' button
		driver.findElement(By.xpath("//button[@id='check_rating']")).click();
		
		String expectedText = "Well done!";
		String actualText = driver.findElement(By.id("validate_rating")).getText();
		
		if(actualText.equals(expectedText)) {
			System.out.println("Well Done! - Verified, stars are matched");
		} else {
			System.out.println("Try again - stars are not matched");
		}
		
		driver.quit();

	}

}
