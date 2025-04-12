package javascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollUntilVisibilityOfElement {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		WebElement elementRef = driver.findElement(By.xpath("//strong[normalize-space()='Community poll']"));
		jse.executeScript("arguments[0].scrollIntoView();", elementRef);
		System.out.println(jse.executeScript("return window.pageYOffset;")); // 1935.199951171875

	}

}
