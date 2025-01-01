package alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlertWithoutSwitchToButByExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(10)); // Declaration of explicit wait
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
		System.out.println("Clicked on simple alert button");		
		Thread.sleep(4000);
		
		Alert alrt = wt.until(ExpectedConditions.alertIsPresent());
		System.out.println(alrt.getText());
		alrt.accept();
		
//		If No alert window: AlertNotFoudException


	}

}
