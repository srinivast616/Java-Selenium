package com.sample.pagefactory.utils;


import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver, String testName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = System.getProperty("user.dir") + "screenshots/" + testName + ".png";
            File dest = new File(path);
            Files.copy(src.toPath(), dest.toPath());
            return dest.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    public static com.aventstack.extentreports.MediaEntityModelProvider addScreenshotToReport(String path) {
    public static Media addScreenshotToReport(String path) {
        try {
            return MediaEntityBuilder.createScreenCaptureFromPath(path).build();
        } catch (Exception e) {
            return null;
        }
    }
}
