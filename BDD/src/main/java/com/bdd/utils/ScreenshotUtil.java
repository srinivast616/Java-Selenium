package com.bdd.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtil {
    public static String captureScreenshot(String name) {
        TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
        File src = ts.getScreenshotAs(OutputType.FILE);
        String path = "screenshots/" + name + ".png";
        File dest = new File(path);
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}

