package testNG_DependsOnMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependancyOnMethods {
	@Test(priority = 1)
	void openapp() {
		Assert.assertTrue(true);
	}

	@Test(priority = 2)
	void login() {
		Assert.assertTrue(false);
	}

	@Test(priority = 3, dependsOnMethods = {"login","openapp"})
	void search() {
		Assert.assertTrue(true);
	}

	@Test(priority = 4, dependsOnMethods = {"search"})
	void advancedSearch() {
		Assert.assertTrue(true);
	}

	@Test(priority = 5)
	void logout() {
		Assert.assertTrue(true);
	}
}
