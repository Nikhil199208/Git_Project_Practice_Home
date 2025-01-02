package Practice;

import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport 
{
 public ExtentSparkReporter sparkreporter;
 
 public ExtentReports extentreports;
 
 public ExtentTest extenttest;
 
 public void OnStart(ITestContext context)
 {
	 sparkreporter= new ExtentSparkReporter(System.getProperty("user.dir")+"//testdata//MyReport.html");
	 
	 sparkreporter.config().setDocumentTitle("My Extent Report");
	 
	 sparkreporter.config().setReportName("My Report");
	 
	 sparkreporter.config().setTheme(Theme.DARK);
	 
	 extentreports=new ExtentReports();
	 
	 extentreports.attachReporter(sparkreporter);
	 
	 extentreports.setSystemInfo("Computer Name", "LocalHost");
	 extentreports.setSystemInfo("Environment", "Testing");
	 extentreports.setSystemInfo("Tester Name", "Nikhil Pidurkar");
	 extentreports.setSystemInfo("Operating System", "Windows");
	 extentreports.setSystemInfo("Browser","Chrome");
	 
 }
 
 public void OnTestSuccess(ITestResult result)
 {
	 extenttest=extentreports.createTest(result.getName());
	 extenttest.log(Status.PASS,"Test Case Passed is:"+result.getName());
	 
 }
 
 public void OnTestFailure(ITestResult result)
 {
	 extenttest=extentreports.createTest(result.getName());
	 extenttest.log(Status.FAIL,"Test Case Failed is:"+result.getName());
 }
 
 public void OnTestSkipped(ITestResult result)
 {
	 extenttest=extentreports.createTest(result.getName());
	 extenttest.log(Status.SKIP,"Test case Skipped is:"+result.getName());
 }
 
 public void OnFinish(ITestContext context)
 {
	 extentreports.flush();
 }
 
}
