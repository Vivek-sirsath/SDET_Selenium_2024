package testNG_BTAT_BSAS;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class C3 {
	@Test
	void m7() {
		System.out.println("This is test method from C3");
	}

	@AfterSuite
	void as() {
		System.out.println("AfterSuite method...");
	}

	@BeforeSuite
	void bs() {
		System.out.println("BeforeSuite method...");
	}

}
