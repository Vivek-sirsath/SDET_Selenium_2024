package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassVsActionInterface2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

		WebElement rightClickMeBtn = driver.findElement(By.xpath("//span[contains(.,'right click me')]"));

		Actions act = new Actions(driver);

		Action myAction = act.contextClick(rightClickMeBtn).build(); // Creating action
		myAction.perform(); // Completing the action
		System.out.println("Right click button clicked...");

	}

}
