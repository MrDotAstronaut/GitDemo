import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
    private static ExtentReports extent = new ExtentReports();
    public static ExtentReports reportConfig(){
        String path = ".\\Reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "John Thomas");
        return extent;
    }
}
