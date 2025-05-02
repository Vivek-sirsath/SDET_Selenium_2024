package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/");
		
		// Main Menu Tabs mouse hover
		WebElement desktopTAB = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement laptopsAndNotebookTAB = driver.findElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
		WebElement componentsTAB = driver.findElement(By.xpath("//a[normalize-space()='Components']"));
		WebElement mp3PlayersTAB = driver.findElement(By.xpath("//a[normalize-space()='MP3 Players']"));
		
		// Sub-Menu Tabs mouse hover
		WebElement mac1SubTAB = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		
		Actions act = new Actions(driver);
		
		// Mouse hover over the all tabs
		act.moveToElement(desktopTAB).build().perform();
		Thread.sleep(3000);
		act.moveToElement(laptopsAndNotebookTAB).build().perform();
		Thread.sleep(3000);
		act.moveToElement(componentsTAB).build().perform();
		Thread.sleep(3000);
		act.moveToElement(mp3PlayersTAB).build().perform();
		Thread.sleep(3000);
		
		// Mouse hover and click on the sub elements
		// Method Chaining - Using multiple methods successively
		act.moveToElement(desktopTAB).moveToElement(mac1SubTAB).click().build().perform();

	}

}
