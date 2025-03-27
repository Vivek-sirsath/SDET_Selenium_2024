package dataDrivenTesting;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(
				"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		// Assignment - https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[@id='wzrk-cancel']")).click();
		
		String filePath = System.getProperty("user.dir") + "\\testData\\CalData.xlsx"; // -->FileNotFoundException
		int noOfRows = ExcelUtils.getRowCount(filePath, "sheet1"); // --> IOException

		for (int i = 1; i <= noOfRows; i++) {

//		    Read data from excel
			String PrincipleAmt = ExcelUtils.getCellData(filePath, "sheet1", i, 0); // --> IOException
			String ROI = ExcelUtils.getCellData(filePath, "sheet1", i, 1); // --> IOException
			String tenure = ExcelUtils.getCellData(filePath, "sheet1", i, 2); // --> IOException
			String tenurePeriod = ExcelUtils.getCellData(filePath, "sheet1", i, 3); // --> IOException
			String freq = ExcelUtils.getCellData(filePath, "sheet1", i, 4); // --> IOException

			String exp_mValue = ExcelUtils.getCellData(filePath, "sheet1", i, 5); // --> IOException

//			Pass the above data in to application
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(PrincipleAmt);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(ROI);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(tenure);

			Select tenureDrpDown = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			tenureDrpDown.selectByVisibleText(tenurePeriod);

			Select freqDrpDown = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			freqDrpDown.selectByVisibleText(freq);

			driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();

//			Validation
			String act_mValue = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();

			// The resulting actual value comes in decimals, So we can't compare as integer.
			// We've to convert them in double format.
			if (Double.parseDouble(act_mValue) == Double.parseDouble(exp_mValue)) {
				System.out.println("Test Passed...");
				ExcelUtils.setCellData(filePath, "sheet1", i, 7, "Passed"); // --> IOException
				ExcelUtils.fillGreenColor(filePath, "sheet1", i, 7); // --> IOException
			} else {
				System.out.println("Test Failed...");
				ExcelUtils.setCellData(filePath, "sheet1", i, 7, "Failed"); // --> IOException
				ExcelUtils.fillRedColor(filePath, "sheet1", i, 7); // --> IOException
			}
			
			// Click on clear button
			Thread.sleep(5000); // --> InterruptedException
			driver.findElement(By.xpath("//img[@class='PL5']")).click();

		} // for loop ended
		
		driver.close();

	}

}
