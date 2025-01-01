package dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropdown {

	public static void main(String[] args) throws InterruptedException {

		// //button[contains(@class,'multiselect')]
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");

		// Click on dropdown
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();

		// Select single option from dropdown
		driver.findElement(By.xpath("//input[@value='Java']")).click();

		// Select all the options from dropdown
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect' )]//label"));

		// Deselect selected options
		for (WebElement op : options) {

			String option = op.getText();

			if ((option.equals("HTML") || option.equals("CSS") || option.equals("Java"))) {
				op.click();
			}
		}
		System.out.println("Deselected previously selected options");

		for (WebElement eachOption : options) {

			if (!eachOption.isSelected()) {
				eachOption.click();
			}
		}
		System.out.println("All options are selected");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		System.out.println("Clicked on dropdown");
		

	}

}
