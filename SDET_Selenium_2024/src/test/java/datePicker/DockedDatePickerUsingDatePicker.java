package datePicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DockedDatePickerUsingDatePicker {

	// Select Future Date
	static void selectFutureDate(WebDriver driver, String year, String month, String date) {

		while (true) {

			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (currentMonth.equals(month) && currentYear.equals(year)) {
				break;
			}

			// Click on right arrow icon button in calendar until matches future month and
			// year
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // Right Button
//			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); // Left Button
		}

		List<WebElement> allDates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));

		for (WebElement dt : allDates) {

			if (dt.getText().equals(date)) {
				dt.click();
				break;
			}

		}

	}

	// Select Past Date
	static void selectPastDate(WebDriver driver, String year, String month, String date) {

		while (true) {

			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (currentMonth.equals(month) && currentYear.equals(year)) {
				break;
			}

			// Click on left arrow icon button in calendar until matches past month and year
//				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // Right Button
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); // Left Button
		}

		List<WebElement> allDates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));

		for (WebElement dt : allDates) {

			if (dt.getText().equals(date)) {
				dt.click();
				break;
			}

		}

	}

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");

		// Switch to frame first because date picker is inside iframe.
		driver.switchTo().frame(0);

		// Open DatePicker
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		String year = "2024";
		String month = "February";
		String date = "12";

		selectPastDate(driver, year, month, date);

	}

}
