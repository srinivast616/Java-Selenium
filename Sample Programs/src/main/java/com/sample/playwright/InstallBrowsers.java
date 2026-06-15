package com.sample.playwright;

import com.microsoft.playwright.Playwright;

public class InstallBrowsers {
	
	public static void main(String[] args) {
        Playwright.create(); // This automatically installs supported browsers
    }

}
