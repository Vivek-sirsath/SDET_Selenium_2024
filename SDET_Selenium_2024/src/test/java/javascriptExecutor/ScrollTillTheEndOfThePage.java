package javascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollTillTheEndOfThePage {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		// Scroll till the end of the page
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(jse.executeScript("return window.pageYOffset;")); // 1968
		
		Thread.sleep(5000);
		
		// Scroll back to the top of the page
		jse.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(jse.executeScript("return window.pageYOffset;")); // 0

	}

}
