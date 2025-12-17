package chromeOptions;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnableExtensionsInAutomatedBrowser {

	public static void main(String[] args) {
		
		String crxFilePath = "F:\\Automation Testing\\SDET 2024 Java + Selenium\\CRX files for Extensions\\SelectorsHub-XPath-Helper-Chrome-Web-Store.crx";
		
		ChromeOptions setting = new ChromeOptions();
		
		File path = new File(crxFilePath);
		
		setting.addExtensions(path);
		
		WebDriver driver = new ChromeDriver(setting);
		
		driver.manage().window().maximize();
		
		driver.get("https://text-compare.com/");
		

	}

}
