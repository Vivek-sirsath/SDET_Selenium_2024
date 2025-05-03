package mouseActions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement clickMeBtn = driver.findElement(By.xpath("//span[contains(normalize-space(),'right click me')]"));
		
		Actions act = new Actions(driver);
		act.contextClick(clickMeBtn).perform();
		
		Thread.sleep(10000);
		
		// click on copy
		driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();
			
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();

	}

}
