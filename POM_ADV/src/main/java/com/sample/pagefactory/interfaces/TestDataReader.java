package com.sample.pagefactory.interfaces;

import java.util.Map;

public interface TestDataReader {
    Map<String, String> getTestData(String testCaseId);
}
