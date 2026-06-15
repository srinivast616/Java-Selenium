package com.gym.management;

// ===== Parent Class =====
class Participant {
    private String name;
    private int age;

    public Participant(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    // This will be overridden
    public void notifyBatchStart(String batchName) {
        System.out.println(name + " has been notified that the batch '" + batchName + "' has started.");
    }
}
