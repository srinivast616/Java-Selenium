package com.sample.pagefactory.interfaces;

public interface ReportManager {
	void logInfo(String message);
    void logPass(String msg);
    void logFail(String msg);
    void flush();
    void attachScreenshot(String path);
}

