package alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PromptAlert {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

// Prompt alert with InputBox, OK button, Cancel button
		
// Case 1 - If we don't enter any text, just click on OK Button
		driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
		System.out.println("1. First time clicked on prompt alert button");

		Thread.sleep(4000);

		Alert al1 = driver.switchTo().alert();
		al1.accept();
		System.out.println("Not entered any text, clicked on OK button");

		WebElement result1 = driver.findElement(By.cssSelector("#result"));
		System.out.println("Result:- " + result1.getText());
//===============================================================================		

// Case 2 - If we don't enter any text, just click on Cancel Button

		driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
		System.out.println("2. Second time clicked on prompt alert button");

		Thread.sleep(4000);

		Alert al2 = driver.switchTo().alert();
		al2.dismiss();
		System.out.println("Not entered any text, clicked on Cancel button");

		WebElement result2 = driver.findElement(By.cssSelector("#result"));
		System.out.println("Result:- " + result2.getText());

// ===============================================================================

// Case 3 - If we enter any text, click on OK Button

		driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
		System.out.println("3. Third time clicked on prompt alert button");

		Thread.sleep(4000);

		Alert al3 = driver.switchTo().alert();
		al3.sendKeys("Vivek Shirsath");
		Thread.sleep(4000);
		al3.accept();
		System.out.println("Entered some text, clicked on OK button");

		WebElement result3 = driver.findElement(By.cssSelector("#result"));
		System.out.println("Result:- " + result3.getText());
	}

}
