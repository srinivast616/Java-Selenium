package com.java.programs;

public class SynchronousExample {
    public static void main(String[] args) {
        System.out.println("Start");

        String result = fetchData();
        System.out.println("Result: " + result);

        System.out.println("End");
    }

    public static String fetchData() {
        try {
            Thread.sleep(3000); // Simulates long-running task (3 sec)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Data from server";
    }
}
