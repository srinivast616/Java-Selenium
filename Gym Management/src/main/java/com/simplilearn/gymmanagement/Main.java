package com.simplilearn.gymmanagement;

import java.util.Scanner;

public class Main {	
	public static void main(String[] args) {		
        Scanner sc = new Scanner(System.in);
        // Create Batch
        System.out.print("Enter Batch Name: ");
        String batchName = sc.nextLine();
        System.out.print("Enter Batch Time (e.g., Morning/Evening): ");
        String batchTime = sc.nextLine();
        Batch batch = new Batch(batchName, batchTime);
        // Add Participants
        System.out.print("Enter number of participants: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Participant " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.print("Contact Number: ");
            String contact = sc.nextLine();
            Participant p = new Participant(name, age, contact);
            batch.addParticipant(p);
        }
        // Start Batch
        batch.startBatch();
        sc.close();
    }
}
