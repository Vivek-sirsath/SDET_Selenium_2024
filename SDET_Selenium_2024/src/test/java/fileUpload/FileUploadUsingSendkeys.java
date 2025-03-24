package fileUpload;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadUsingSendkeys {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php/");

		// Scenario 1 - Single file upload
		driver.findElement(By.xpath("//input[@id='filesToUpload']"))
				.sendKeys("F:\\Automation Testing\\SDET 2024 Java + Selenium\\SDET_Selenium_2024_37_FileUpload_01.txt");

		if (driver.findElement(By.xpath("//ul[@id='fileList']/li")).getText()
				.equals("SDET_Selenium_2024_37_FileUpload_01.txt")) {
			System.out.println("File successfully uploaded");
		} else {
			System.out.println("Upload failed");
		}

		// Scenario 2 - Multiple file upload
		String file2Path = "F:\\Automation Testing\\SDET 2024 Java + Selenium\\SDET_Selenium_2024_37_FileUpload_02.txt";
		String file3Path = "F:\\Automation Testing\\SDET 2024 Java + Selenium\\SDET_Selenium_2024_37_FileUpload_03.txt";

		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file2Path + "\n" + file3Path);

		int noOfFilesUploaded = driver.findElements(By.xpath("//ul[@id='fileList']/li")).size();

		// Validate the no. of files uploaded.
		if (noOfFilesUploaded == 3) {
			System.out.println("All files uploaded successfully");
		} else {
			System.out.println("File uploading failed...");
		}

		String file1Name = "SDET_Selenium_2024_37_FileUpload_01.txt";
		String file2Name = "SDET_Selenium_2024_37_FilUpload_02.txt";
		String file3Name = "SDET_Selenium_2024_37_FileUpload_03.txt";

		// Validate the names of the files uploaded
		for (int i = 1; i <= noOfFilesUploaded; i++) {
			if (driver.findElement(By.xpath("//ul[@id='fileList']//li[" + i + "]")).getText().equals(file1Name)
					|| driver.findElement(By.xpath("//ul[@id='fileList']//li[" + i + "]")).getText().equals(file2Name)
					|| driver.findElement(By.xpath("//ul[@id='fileList']//li[" + i + "]")).getText()
							.equals(file3Name)) {
				System.out.println("File "+i+" name matched");
			} else {
				System.out.println("File "+i+" name not matched...");
			}
		}

	}

}
