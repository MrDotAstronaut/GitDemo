import InitialSetup.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;

public class Listeners extends Base implements ITestListener {
    private ExtentTest test;
    private ExtentReports extent = ExtentReporter.reportConfig();
    private ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed.");
        extent.flush();
    }
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());
        WebDriver driver = null;
        String testname = result.getMethod().getMethodName();
        try {
            driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String dst = "." + getScreenshotPath(testname,driver);
            extentTest.get().addScreenCaptureFromPath(dst, testname);
        } catch (IOException e) {
            e.printStackTrace();
        }
        extent.flush();
    }
    public void onTestSkipped(ITestResult result) {

    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }
    public void onTestFailedWithTimeout(ITestResult result) {

    }
    public void onStart(ITestContext context) {

    }
    public void onFinish(ITestContext context) {

    }
}
