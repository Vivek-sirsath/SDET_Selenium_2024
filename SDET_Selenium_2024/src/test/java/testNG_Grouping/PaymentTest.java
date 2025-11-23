package testNG_Grouping;

import org.testng.annotations.Test;

public class PaymentTest {

	@Test(priority = 1, groups = { "sanity", "regression", "functional" }) // functional is the name given to both
																			// groups
	void paymentInRupees() {
		System.out.println("Payment in rupees...");
	}

	@Test(priority = 2, groups = { "sanity", "regression", "functional" })
	void paymentInDollars() {
		System.out.println("Payment in dollars...");
	}

}
