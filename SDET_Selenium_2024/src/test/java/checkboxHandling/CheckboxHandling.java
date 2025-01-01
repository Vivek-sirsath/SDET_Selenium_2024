package checkboxHandling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxHandling {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");

//		1) Select specific check-box
//		driver.findElement(By.xpath("//input[@id='monday']")).click();

//		2) Select all the check-boxes using normal for loop
		List<WebElement> chkBoxes = driver
				.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox'] "));

//		for (int i = 0; i < chkBoxes.size(); i++) {
//			chkBoxes.get(i).click();
//		}
// =======================================================================================
		
//		3) Select all the check-boxes using enhanced for loop
//		for (WebElement chkBox : chkBoxes) {
//			chkBox.click();
//		}
// =======================================================================================
		
//		4) Select last 3 check boxes
//		starting index = total no of check boxes - how many check boxes we want to select
//		7 - 3 = 4
		
//		for(int i = 4; i<chkBoxes.size(); i++) {
//			chkBoxes.get(i).click();
//		}
// =======================================================================================
		
//		5) Select first 3 check boxes
		for(int i = 0; i<3; i++) {
			chkBoxes.get(i).click();
		}
		
	}

}
