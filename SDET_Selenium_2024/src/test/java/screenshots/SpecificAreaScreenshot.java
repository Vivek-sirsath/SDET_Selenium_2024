package screenshots;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpecificAreaScreenshot {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		
		WebElement newsArea = driver.findElement(By.xpath("//div[@class='news-items']"));
		
		// Here getScreenshotAs() method we're calling from WebElement Interface
		File sourceFile = newsArea.getScreenshotAs(OutputType.FILE); 
		
		File targetFile = new File(System.getProperty("user.dir")+"\\screenshots\\specificArea.png");
		sourceFile.renameTo(targetFile); // Copies file from source to target folder.

	}

}
