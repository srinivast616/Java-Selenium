package com.simplilearn.gymmanagement;

public class Participant {
    private String name;
    private int age;
    private String contactNumber;

    public Participant(String name, int age, String contactNumber) {
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
    }

    public void onBatchStart(String batchName) {
        System.out.println("Hello " + name + "! Your " + batchName + " batch is starting now.");
    }

    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
