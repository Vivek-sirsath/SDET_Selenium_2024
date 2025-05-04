package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassVsActionInterface {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

		WebElement rightClickMeBtn = driver.findElement(By.xpath("//span[contains(.,'right click me')]"));

		Actions act = new Actions(driver);

	    act.contextClick(rightClickMeBtn).build().perform();
	    // We can use Actions class object to perform the actions directly.
	    // No need to store the action in Action interface.
		
		System.out.println("Right click button clicked...");

	}

}
