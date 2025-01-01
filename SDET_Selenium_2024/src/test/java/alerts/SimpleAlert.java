// NOTE: Alert is not a web element

package alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleAlert {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

// Simple / Normal alert with OK button only.
		driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
		System.out.println("Clicked on simple alert button");
		
		Thread.sleep(4000);

//		driver.switchTo().alert().accept(); // Possible and works.
		Alert al = driver.switchTo().alert(); // Variable type is alert not WebElement
		System.out.println(al.getText());
		al.accept();
		System.out.println("Alert accepted");
		
		Thread.sleep(3000);
		
		driver.close();
	}

}
