package shadowDOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UnderstandingShadowDOM2 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://books-pwakit.appspot.com/");
		
		SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		shadow.findElement(By.cssSelector("#input")).sendKeys("Jurassic Park");
		
		if (driver != null) {
            driver.quit();
        }

	}

}
