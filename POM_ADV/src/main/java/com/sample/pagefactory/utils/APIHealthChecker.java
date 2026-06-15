package com.sample.pagefactory.utils;

import java.net.HttpURLConnection;
import java.net.URL;

import com.sample.pagefactory.interfaces.ReportManager;

public class APIHealthChecker {
	
	private final ReportManager report;

    public APIHealthChecker(ReportManager report) {
        this.report = report;
    }

    public void verifyAllServices() {
        String urls = ConfigReader.get("api.health.urls");

        if (urls == null || urls.isEmpty()) {
            throw new RuntimeException("❌ No API URLs defined in config.properties");
        }

        String[] urlList = urls.split(",");

        for (String url : urlList) {
            url = url.trim();
            boolean healthy = isAPIUp(url);
            if (!healthy) {
            	report.logFail("❌ API down: " + url);
                throw new RuntimeException("API health check failed for: " + url);
            } else {
            	report.logPass("✅ API healthy: " + url);
            	System.out.println("API healthy: " + url);
            }
        }
    }

    public static boolean isAPIUp(String endpoint) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(endpoint).openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            int responseCode = conn.getResponseCode();
            return (responseCode == 200);
        } catch (Exception e) {
            System.err.println("❌ API unreachable: " + endpoint + " | " + e.getMessage());
            return false;
        }
    }
    
    /*
    public static void verifyAllServices2() {
    int index = 1;
    while (true) {
        String url = ConfigReader.get("api.health.url." + index);
        if (url == null) break;

        boolean healthy = isAPIUp(url.trim());
        if (!healthy) {
            throw new RuntimeException("❌ API health check failed for: " + url);
        } else {
            System.out.println("✅ API healthy: " + url);
        }

        index++;
    }
    */
}
