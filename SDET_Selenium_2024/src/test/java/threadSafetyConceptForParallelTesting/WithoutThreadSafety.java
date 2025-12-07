
/*
  Parallel Execution without thread safety:
  
  - Same driver instance is used by both test methods. If executed simultaneously one after another.
  - There will be no issue by using same driver instance.
  - The problem occurs when we execute these test methods parallely.
*/
package threadSafetyConceptForParallelTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WithoutThreadSafety {

	WebDriver driver;
	
	@Test
	void testChrome() {
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		System.out.println(driver.getTitle());
		driver.quit();
	}
	
	@Test
	void testEdge() {
		driver = new FirefoxDriver();
		driver.get("https://testautomationpractice.blogspot.com");
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
