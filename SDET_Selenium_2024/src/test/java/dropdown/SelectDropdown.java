package dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement dd = driver.findElement(By.xpath("//select[@id='country']"));
		Select sel = new Select(dd);
		// sel.selectByVisibleText("India");
		// sel.selectByValue("france"); // Case Sensitive
		// sel.selectByIndex(2);

		// Capture the options from the dropdown
		List<WebElement> options = sel.getOptions();
		System.out.println("No of dropdowns:- " + options.size());

		// Print all options by normal for loop
		for (int i = 0; i < options.size(); i++) {
			System.out.println(options.get(i).getText());
		}
	}

}
