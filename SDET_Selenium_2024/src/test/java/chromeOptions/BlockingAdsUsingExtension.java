package chromeOptions;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlockingAdsUsingExtension {

	public static void main(String[] args) throws InterruptedException {

		 WebDriverManager.chromedriver().setup();

	        ChromeOptions setting = new ChromeOptions();
	        setting.addExtensions(new File("F:\\Automation Testing\\CRX Files\\uBlock-Origin-LiteMV3.crx"));
	        // Manifest V3 is a new architecture for Chrome extensions.
	       
	        WebDriver driver = new ChromeDriver(setting);
	        driver.manage().window().maximize();

	        Thread.sleep(3000); // wait for extensions to load completely

	        driver.get("https://text-compare.com/");
	        System.out.println("Extension blocked the adds successfully");
	}

}
