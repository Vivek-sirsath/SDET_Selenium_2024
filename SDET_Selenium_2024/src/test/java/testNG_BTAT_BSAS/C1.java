package testNG_BTAT_BSAS;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class C1 {
	@Test(priority = 1)
	void m1() {
		System.out.println("This is test method 1 from C1...");
	}

	@AfterTest
	void at() {
		System.out.println("AfterTest method...");
	}

	@Test(priority = 3)
	void m3() {
		System.out.println("This is test method 3 from C1...");
	}

	@Test(priority = 2)
	void m2() {
		System.out.println("This is test method 2 from C1...");
	}
}
