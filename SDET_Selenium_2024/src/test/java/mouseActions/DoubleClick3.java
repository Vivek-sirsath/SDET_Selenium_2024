package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick3 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.w3schools.com/jsrEF/tryit.asp?filename=tryjsref_ondblclick");
		
		driver.switchTo().frame("iframeResult");
		System.out.println("Switched to frame");
		
		WebElement paragraph = driver.findElement(By.xpath("//p[@ondblclick='myFunction()']"));
		
		Actions act = new Actions(driver);
		act.doubleClick(paragraph).perform();
		System.out.println("Double cllick done");
		
		String result = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println(result);

	}

}
