package windowHandling;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetWindowHandlesForMultipleWindows {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // 1

		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click(); // 2
		
		// To open new tab
		driver.switchTo().newWindow(WindowType.TAB).get("https://www.google.co.in/"); // 3
		
		// To open new window
		driver.switchTo().newWindow(WindowType.WINDOW).get("https://testautomationpractice.blogspot.com/"); // 4

		Set<String> windowIDs = driver.getWindowHandles();
		System.out.println("Number of window handles:- " + driver.getWindowHandles().size());

		for (String winID : windowIDs) {

			String title = driver.switchTo().window(winID).getTitle();

			if (title.equals("Google")) {
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());
				driver.close();
				System.out.println("Window handled successfully");
			}
		}

	}

}
