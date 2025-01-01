package frame_and_iFrame;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Nested_iFrame {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");

		Thread.sleep(5000);

//		Interacting with Frame3
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Frame3 Text");

//		Switching to the inner iFrame
		// Switching to frame using index, coz there's only a single iFrame inside Frame				
		driver.switchTo().frame(0);
		
		// Clicking on radio button
		List<WebElement> allRadioButtons = driver.findElements(By.xpath("//div[@role=\"radio\"]"));
		for(WebElement radioBtn : allRadioButtons) {
			radioBtn.click();
			Thread.sleep(3000);
		}
		System.out.println("Inside iFrame - All radio buttons are clickable");

		// Clicking on all check-boxes
		List<WebElement> allChkBoxes = driver.findElements(By.xpath("//div[@role='checkbox']"));
		System.out.println(allChkBoxes.size());

		for (WebElement ChkBox : allChkBoxes) {
			ChkBox.click();
			Thread.sleep(3000);
		}
		System.out.println("Inside iFrame - All check Boxes are selectable");
		
		driver.close();

	}

}
