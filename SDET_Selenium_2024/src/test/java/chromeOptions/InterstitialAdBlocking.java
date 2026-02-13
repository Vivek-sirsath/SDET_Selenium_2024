package chromeOptions;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InterstitialAdBlocking {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();

        ChromeOptions setting = new ChromeOptions();
        setting.addExtensions(new File("H:\\Automation Testing\\CRX Files\\uBlock-Origin-LiteMV3.crx"));
        // Manifest V3 is a new architecture for Chrome extensions.
       
        WebDriver driver = new ChromeDriver(setting);
        driver.manage().window().maximize();

        Thread.sleep(3000); // wait for extensions to load completely

        driver.get("https://canyoublockit.com/");
        
        // Click on 'Simple Test Button'
        driver.findElement(By.xpath("//a[@id='TestingButton']")).click();
        
        
        System.out.println("Extension blocked the adds successfully");

	}

}
