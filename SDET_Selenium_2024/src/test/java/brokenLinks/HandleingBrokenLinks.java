package brokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleingBrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://deadlinkcity.com/");
		
		int noOFBrokenLinks = 0;

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total no. of links: " + allLinks.size());

		for (WebElement link : allLinks) {
			String hrefValue = link.getAttribute("href");

			if (hrefValue == null || hrefValue.isEmpty()) {
				System.out.println("href attribute value is null or empty, So not possible to verify the link");
				continue;
			}

			// To hit the URL to the server, first we need to convert the URL from String to
			// URL format.
			URL linkURL = new URL(hrefValue); // Exception - MalformedURLException

			// Now we need to create a connection
			// Now we have to hit the server using this 'HttpURLConnection' Class and
			// 'linkURL' Object
			HttpURLConnection connection = (HttpURLConnection) linkURL.openConnection(); // Exception - IOException

			// Now we need to send the request
			connection.connect(); // This sends the request to the server.

			if (connection.getResponseCode() >= 400) {
				System.out.println("Broken Link : " + hrefValue);
				noOFBrokenLinks++;
			} else {
				System.out.println("Ok Link : " + hrefValue);
			}

		}
		
		System.out.println("Number of broken links: " + noOFBrokenLinks);

	}

}
