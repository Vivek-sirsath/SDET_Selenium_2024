package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_All_Annotations {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Its a beforesuite annotation");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Its a beforetest annotation");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Its a beforeclass annotation");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Its a beforemethod annotation");
	}

	@Test
	public void scheduleAppointment() {
		System.out.println("Its a test annotation");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Its an aftermethod annotation");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Its an afterclass annotation");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Its an aftertest annotation");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Its an aftersuite annotation");
	}

}
