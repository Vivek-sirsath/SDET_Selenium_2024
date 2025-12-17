package chromeOptions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessBrowserTesting {

	public static void main(String[] args) {
		
		ChromeOptions setting = new ChromeOptions();
		setting.addArguments("--headless=new"); // setting for headless mode of execution
		
		WebDriver driver = new ChromeDriver(setting);
		// We've to pass the options here, else the browser will launch

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		String pageTitle = driver.getTitle();
		
		if(pageTitle.equals("Automation Testing Practice")) {
			System.out.println("Title test passed");
		} else {
			System.out.println("Title test failed");
		}

	}

}
