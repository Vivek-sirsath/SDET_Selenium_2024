package chromeOptions;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BlockingAdsUsingExtension {

	public static void main(String[] args) {

		String crxFilePath = "F:\\Automation Testing\\SDET 2024 Java + Selenium\\CRX files for Extensions\\uBlock-Origin-Chrome-Web-Store.crx";

		ChromeOptions options = new ChromeOptions();

		File uBlockExtensionCrx = new File(crxFilePath);

		options.addExtensions(uBlockExtensionCrx);

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://text-compare.com/");

	}

}
