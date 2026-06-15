package com.java.programs;

import java.util.concurrent.*;

public class AsynchronousExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("Start");

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(() -> {
            Thread.sleep(3000); // Simulate long-running task
            return "Data from server";
        });

        System.out.println("Doing other work...");

        // Get result when ready
        String result = future.get(); // This will block only here
        System.out.println("Result: " + result);

        executor.shutdown();
        System.out.println("End");
    }
}
