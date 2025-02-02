package dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestionDropdown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.co.in/");
		
		driver.findElement(By.name("q")).sendKeys("Selenium"); // SearxhBox x path
		Thread.sleep(5000);
		
		List <WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
		
		// Print total no of auto suggestions
		System.out.println(list.size());
			
		for(int i = 0; i <= list.size(); i++) {
			
			System.out.println(list.get(i).getText());
			
			if (list.get(i).getText().equals("selenium")) {
				list.get(i).click();
				break;
			}
		}

	}

}
