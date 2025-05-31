package propertiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class PropertiesFileReading {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		// Open the properties file in the reading mode
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testData\\config.properties");
		// --> FileNotFoundException

		// Create Properties class object
		Properties prop = new Properties();

		// Load properties file
		prop.load(file); // --> IOException

		// Reading from the properties file, returns values using keys
		String url = prop.getProperty("appurl");
		String email = prop.getProperty("email");
		String pwd = prop.getProperty("password");
		String ordrid = prop.getProperty("orderid");
		String custid = prop.getProperty("customerid");

		// Print values of the keys
		System.out.println(url + "\t" + email + "\t" + pwd + "\t" + ordrid + "\t" + custid); // "\t" - tabspace

		// Reading all the keys from the properties file
//		Set<Object> keys = prop.keySet(); // Return keys as an object
		// [password, orderid, customerid, appurl, email]

		Set<String> keys = prop.stringPropertyNames();
		System.out.println(keys); // [password, orderid, customerid, appurl, email]

		// Reading all values as collection without using keys
		Collection<Object> values = prop.values();
		System.out.println(values); // [pass@456, 201, 66666, https://demo.opencart.com/, abc@gmail.com]

	}

}
