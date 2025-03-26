package windowHandling;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SwitchingTabsUsingActionsClassAndClickMethod {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		
		WebElement regLink = driver.findElement(By.xpath("//a[normalize-space()='Log in']"));
		
		Actions act = new Actions(driver);
		
		// To open Register link in new tab
		// Press Control+Click on register link
		act.keyDown(Keys.CONTROL).click(regLink).keyUp(Keys.CONTROL).perform();
		// New tab with Register link will open but driver focus is still on the Home page tab
		
		// driver.getWindowHandles() will return the Set of IDs
		
		// To convert the Set into List collection
		List<String> tabIDs = new ArrayList(driver.getWindowHandles());
		
		// Switch to Register tab
		driver.switchTo().window(tabIDs.get(1));
		
		// Enter First Name
		driver.findElement(By.id("Email")).sendKeys("vivek.sirsath@nopcommerce.com");
		
		// Driver focus return to parent tab
		driver.switchTo().window(tabIDs.get(0));
		driver.findElement(By.id("small-searchterms")).sendKeys("Laptop");

	}

}
