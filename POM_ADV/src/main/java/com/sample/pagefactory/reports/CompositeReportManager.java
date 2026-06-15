package com.sample.pagefactory.reports;

import com.sample.pagefactory.interfaces.ReportManager;
import java.util.Arrays;
import java.util.List;

public class CompositeReportManager implements ReportManager {
    private final List<ReportManager> reporters;

    public CompositeReportManager(ReportManager... reporters) {
        this.reporters = Arrays.asList(reporters);
    }

    public void logInfo(String message) {
        reporters.forEach(r -> r.logInfo(message));
    }

    public void logPass(String message) {
        reporters.forEach(r -> r.logPass(message));
    }

    public void logFail(String message) {
        reporters.forEach(r -> r.logFail(message));
    }

    public void flush() {
        reporters.forEach(ReportManager::flush);
    }
}

