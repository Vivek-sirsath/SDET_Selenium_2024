
/*
 * Docked Date Picker:
 * This is simple date picker. In this we can select the date from calendar.
 * Also we can enter the date using sendKeys(), as a string.
 * 
 */

package datePicker;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DockedDatePickerUsingSendkeys {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");

		// Switch to frame first because date picker is inside iframe.
		driver.switchTo().frame(0);

//		Method 1 : Using sendkeys()
//		This method only useful if the datePicker element accepts string.
//		NOTE: The date format in sendkeys() must be same as datePicker element accepts. 
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("01/13/2025"); // mm/dd/yyyy

	}

}
