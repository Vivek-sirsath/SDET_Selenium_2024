package testNG_Listener_ExtentReport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter; // UI of the report
	public ExtentReports report; // populate common info on report
	public ExtentTest test; // Create test case entries in report and update status-pass/fail/skip in report

	public void onStart(ITestContext context) {

		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/ExtReport.html");
		// Here the report name should not be hard-coded, It should be dynamically generated.
		// It should be generated with time stamp.

		sparkReporter.config().setDocumentTitle("Extent Report"); // Title of the report
		sparkReporter.config().setReportName("Functional Testing Report"); // Name of the report
		sparkReporter.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(sparkReporter);

		report.setSystemInfo("Computer Name", "localhost");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("Tester Name", "Vivek");
		report.setSystemInfo("OS", "Windows 10");
		// System info should not be hard-coded.

	}

	public void onTestSuccess(ITestResult result) { // Result object contains all the details about test methods

		test = report.createTest(result.getName()); // Create new entry in report
		test.log(Status.PASS, "Test case passed is: " + result.getName()); // update status p/f/skip
	}

	public void onTestFailure(ITestResult result) {

		test = report.createTest(result.getName());
		test.log(Status.FAIL, "Test case failed is: " + result.getName());
		test.log(Status.FAIL, "Test case failed cause is: " + result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {

		test = report.createTest(result.getName());
		test.log(Status.SKIP, "Test case skipped is: " + result.getName());
	}

	public void onFinish(ITestContext context) {

		report.flush();
	}

}
