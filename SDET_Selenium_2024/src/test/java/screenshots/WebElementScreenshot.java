package screenshots;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementScreenshot {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://time.is/IST");
		
		WebElement logo = driver.findElement(By.xpath("//a[@title='Time.is']"));
		
		File sourceFile = logo.getScreenshotAs(OutputType.FILE);
		
		File targetFile = new File(System.getProperty("user.dir")+"\\screenshots\\logo.png");
		sourceFile.renameTo(targetFile); // Copies file from source to target folder.

	}

}
