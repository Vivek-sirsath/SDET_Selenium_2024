package screenshots;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FullPageScreenshot {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://time.is/IST");
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		
		File targetFile = new File(System.getProperty("user.dir")+"\\screenshots\\fullPage.png");
		// "user.dir" should be written in small letters. "User.dir" will not work.
		
		// 1st Way -
		sourceFile.renameTo(targetFile); // Copies file from source to target folder.
		
		// 2nd Way -
		//Copy source image file to destination using Apache Commons-IO
		// We've to add the dependency of 'Apache commons-io' in POM.xml
		//FileUtils.copyFile(sourceFile, targetFile); // Require to handle IOException

	}

}
