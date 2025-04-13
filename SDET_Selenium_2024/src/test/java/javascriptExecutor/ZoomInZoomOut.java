package javascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomInZoomOut {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		Thread.sleep(5000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("document.body.style.zoom='30%'");
		Thread.sleep(5000);

		jse.executeScript("document.body.style.zoom='50%'");
		Thread.sleep(5000);

		jse.executeScript("document.body.style.zoom='100%'");
		Thread.sleep(5000);
		
		jse.executeScript("document.body.style.zoom='30%'");
		Thread.sleep(5000);

	}

}
