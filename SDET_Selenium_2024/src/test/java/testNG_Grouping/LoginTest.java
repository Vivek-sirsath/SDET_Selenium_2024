package testNG_Grouping;

import org.testng.annotations.Test;

public class LoginTest {

	@Test (priority = 1, groups = {"sanity"})
	void loginByGmail() {
		System.out.println("This is login by Gmail...");
	}

	@Test (priority = 2, groups = {"sanity"})
	void loginByFacebook() {
		System.out.println("This is login by Facebook...");
	}

	@Test (priority = 3, groups = {"sanity"})
	void loginByTweeter() {
		System.out.println("This is login by Tweetwer...");
	}



}
