package testNG_BTAT_BSAS;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C2 {
	@Test(priority = 2)
	void m2() {
		System.out.println("This is test method 2 from C2...");
	}

	@BeforeTest
	void bt() {
		System.out.println("BeforeTest method...");
	}

	@Test(priority = 1)
	void m6() {
		System.out.println("This is test method 1 from C2...");
	}
}
