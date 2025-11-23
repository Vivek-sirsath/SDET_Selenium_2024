
/* 
   Text to be present in Element Value: It checks whether the text associated with the located element
   is present in the value of the value attribute of that element.
   It is not necessary to wait until its visibility. It will require DOM to be loaded.
   For this, The value attribute should be present there and it should be showing the value of that element.
*/

package explicitWaitAndMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextToBePresentInElementValue {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		boolean isTextValuePresent = wait.until(ExpectedConditions.textToBePresentInElementValue(
				driver.findElement(By.id("sunday")), "sunday"));

		if (isTextValuePresent) {
			System.out.println("Text value is present in the element.");
		} else {
			System.out.println("Text value is not present in the element.");
		}
		driver.quit();
	}

}
