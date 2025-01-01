package alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfirmationAlert {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

// Confirmation alert with 2 buttons - (OK button) and (Cancel button).
		
// To accept the alert:- 
		driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
		System.out.println("Clicked on confirmation alert button");
		
		Thread.sleep(4000);
		
		Alert al = driver.switchTo().alert();
		al.accept();
		System.out.println("Clicked on OK button");
		
		WebElement result = driver.findElement(By.cssSelector("#result"));
		System.out.println("Result:- " + result.getText());
//==============================================================================
		
// To cancel the alert:- 		
		
		driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
		System.out.println("Again clicked on confirmation alert button");
		
		Thread.sleep(4000);
		
		Alert al1 = driver.switchTo().alert();
		al1.dismiss();
		System.out.println("Clicked on CANCEL button");
		
		WebElement res = driver.findElement(By.cssSelector("#result"));
		System.out.println("Result:- " + res.getText());
		
		driver.close();

	}

}
