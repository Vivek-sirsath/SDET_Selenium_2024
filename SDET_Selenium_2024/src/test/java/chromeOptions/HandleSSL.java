package chromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleSSL {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true); // accepts ssl certificate
		// By default it is false, we'll make it true.
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
		
		System.out.println("Title of the page: " + driver.getTitle()); // Privacy error

	}

}
