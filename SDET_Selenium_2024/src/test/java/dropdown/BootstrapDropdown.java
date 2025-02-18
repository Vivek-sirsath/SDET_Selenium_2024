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
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect' )]//input"));
		System.out.println("No. of options: " + options.size());

		// Deselect previously selected options
		for (WebElement op : options) {

			String option = op.getText();

			if ((option.equals("HTML") || option.equals("CSS") || option.equals("Java"))) {
				op.click();
			}
		}
		System.out.println("Deselected previously selected options");

		// Select all options
		for (WebElement eachOption : options) {

			if (!eachOption.isSelected()) {
				eachOption.click();
			}
		}
		System.out.println("All options are selected");
		Thread.sleep(5000);

		// Deselect last 3 options and Validate the number of selected options.
		// The toggle button must show the no. of selected options.

		for (int i = 8; i < options.size(); i++) {
			options.get(i).click();
		}
		System.out.println("Last 3 options are deselected");

		List<WebElement> SelectedOptions = driver.findElements(By.xpath("//ul[contains(@class,'multiselect' )]//input"));

		int count = 0;

		for (WebElement so : SelectedOptions) {

			if (so.isSelected()) {
				count++;
			}
		}

		System.out.println("No. of selected options: " + count);

		String noOfOptionsOnLabelText = driver.findElement(By.xpath("//span[@class='multiselect-selected-text']")).getText();
		String countText = (count + " selected");

		// Validate the no. of options displayed in toggle button text.

		if (noOfOptionsOnLabelText.equals(countText)) {
			System.out.println("No. of selected options in toggle button text verified");
		}
	}

}
