package frame_and_iFrame;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Nested_iFrame2 {

	public static void main(String[] args) throws InterruptedException {
		

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");

		Thread.sleep(5000);

//		Interacting with Frame3
		WebElement frame5 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(frame5);
		driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("Frame5 Text");
		
		// Click on the link given in Frame5
		driver.findElement(By.linkText("https://a9t9.com")).click();
		Thread.sleep(4000);
		
		// Check if the logo is present or not
		WebElement logoImg = driver.findElement(By.xpath("//img[@src='/Content/Images/ui.vision.logo2.webp']"));
		
		if(logoImg.isDisplayed()) {
			System.out.println("Logo is present");
		} else {
			System.out.println("Logo is not present");
		}
        driver.close();
	}

}
