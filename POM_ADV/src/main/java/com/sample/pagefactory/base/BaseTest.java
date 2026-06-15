package com.sample.pagefactory.base;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.sample.pagefactory.interfaces.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.sample.pagefactory.utils.DBUtils;
import com.sample.pagefactory.utils.APIHealthChecker;
import com.sample.pagefactory.utils.ExtentReportManager;
import com.sample.pagefactory.utils.TestNGReportManager;
import reports.*;

@Listeners({ExtentITestListenerClassAdapter.class})
public abstract class BaseTest {
    protected WebDriver driver;
    private DriverManager driverManager;

    @BeforeSuite(alwaysRun = true)
    public void checkServices() {
        DBUtils.checkDBConnection();
        APIHealthChecker.verifyAllServices();
        report = new CompositeReportManager(
                new TestNGReportManager(),
                new ExtentReportManager()
            );

            report.logInfo("🚀 Suite starting: Environment Health Check");

            new DBUtils(report).checkDBConnection();
    }

    @Parameters({"browser", "mode"}) // browser=chrome/firefox, mode=headless/normal
    @BeforeClass
    public void setup(@Optional("chrome") String browser, @Optional("normal") String mode) {
        if (System.getProperty("remote") != null) {
            driverManager = new drivers.RemoteDriverManager(browser, mode);
        } else {
            driverManager = new drivers.LocalDriverManager(browser, mode);
        }
        driver = driverManager.createDriver();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
