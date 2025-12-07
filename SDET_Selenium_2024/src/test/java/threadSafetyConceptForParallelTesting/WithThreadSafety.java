package threadSafetyConceptForParallelTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class WithThreadSafety {

	// Apply Thread Safety using ThreadLocal class
	private static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

	WebDriver driver;

	public void setDriver(WebDriver driver) {
		tdriver.set(driver);
	}

	public WebDriver getDriver() {
		return tdriver.get();
	}

	@Test
	void testChrome() {
		driver = new ChromeDriver();
		setDriver(driver);
		getDriver();
		
		getDriver().get("https://www.google.co.in");
		System.out.println(getDriver().getTitle());
		getDriver().quit();
	}

	@Test
	void testEdge() {
		driver = new FirefoxDriver();
		setDriver(driver);
		getDriver();
		
		getDriver().get("https://testautomationpractice.blogspot.com");
		System.out.println(getDriver().getTitle());
		getDriver().quit();
	}
	
	@AfterClass
	public void tearDown() {
		tdriver.remove();
	}

}
