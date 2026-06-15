package com.sample.pagefactory.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver, String fileName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("screenshots/" + fileName + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}