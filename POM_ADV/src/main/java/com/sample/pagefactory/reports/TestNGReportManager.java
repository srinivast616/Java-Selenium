package com.sample.pagefactory.reports;

import com.sample.pagefactory.interfaces.ReportManager;
import org.testng.Reporter;

public abstract class TestNGReportManager implements ReportManager {
	
	@Override
    public void logInfo(String message) {
        Reporter.log("[INFO] " + message, true);
    }
    
    @Override
    public void logPass(String message) {
        Reporter.log("[PASS] " + message, true);
    }
    
    @Override
    public void logFail(String message) {
        Reporter.log("[FAIL] " + message, true);
    }
    
    @Override
    public void flush() {
        // Nothing needed for TestNG report
    }
    
    @Override
    public void attachScreenshot(String path) {
        // Embed a clickable image in the report
        String html = "<br><a href='" + path + "' target='_blank'>" +
                      "<img src='" + path + "' height='100' width='100'/></a><br>";
        Reporter.log(html, true);
    }
}
