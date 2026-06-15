package com.sample.programs;

import org.testng.annotations.*;

public class AnnotationsExample {
	
	    @BeforeSuite
	    public void beforeSuite() {
	        System.out.println("===> BeforeSuite: Set up DB connection or reporting");
	    }

	    @BeforeTest
	    public void beforeTest() {
	        System.out.println("===> BeforeTest: Prepare data or open browser for test group");
	    }

	    @BeforeClass
	    public void beforeClass() {
	        System.out.println("===> BeforeClass: Initialize page objects or test data for this class");
	    }

	    @BeforeMethod
	    public void beforeMethod() {
	        System.out.println("===> BeforeMethod: Launch browser or reset preconditions");
	    }

	    @Test
	    public void test1() {
	        System.out.println(">>>>> Test1: Executing test logic here");
	    }

	    @Test
	    public void test2() {
	        System.out.println(">>>>> Test2: Executing another test logic");
	    }

	    @AfterMethod
	    public void afterMethod() {
	        System.out.println("===> AfterMethod: Close browser or clean up after test");
	    }

	    @AfterClass
	    public void afterClass() {
	        System.out.println("===> AfterClass: Clean up test class resources");
	    }

	    @AfterTest
	    public void afterTest() {
	        System.out.println("===> AfterTest: Cleanup actions after group of tests");
	    }

	    @AfterSuite
	    public void afterSuite() {
	        System.out.println("===> AfterSuite: Close DB connection or finalize report");
	    }
	}


