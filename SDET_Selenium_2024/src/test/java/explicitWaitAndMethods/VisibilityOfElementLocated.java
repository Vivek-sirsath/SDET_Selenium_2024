package explicitWaitAndMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VisibilityOfElementLocated {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.titleIs("Home Page"));

		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("T Shirt");
		search.sendKeys(Keys.ENTER);

		String txt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='base']"))).getText();
		System.out.println(txt); // Search results for: 'T Shirt'

	}

}
