package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1300)");
		
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		String textBeforeDropping = droppable.getText();
		System.out.println(textBeforeDropping);
		
		Actions act = new Actions(driver);
		
		act.dragAndDrop(draggable, droppable).build().perform();
		System.out.println("Drpooed the element successfully");
		
		String textAfterDropping = droppable.getText();
		System.out.println(textAfterDropping);

	}

}
