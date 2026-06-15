package com.sample.pagefactory.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest_DP {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            { "user1", "pass1" },
            { "user2", "pass2" }
        };
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        // Test steps using the provided data
    }
}
