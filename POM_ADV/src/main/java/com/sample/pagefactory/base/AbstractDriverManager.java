package com.sample.pagefactory.base;

import org.openqa.selenium.WebDriver;
import com.sample.pagefactory.interfaces.DriverManager;

public abstract class AbstractDriverManager implements DriverManager {
    public abstract WebDriver createDriver();
}
