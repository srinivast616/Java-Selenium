package com.gym.management;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create Batch
        System.out.print("Enter batch name: ");
        String batchName = sc.nextLine();

        System.out.print("Enter batch timing (e.g., Morning/Evening): ");
        String timing = sc.nextLine();

        Batch batch = new Batch(batchName, timing);

        // Add Participants
        System.out.print("Enter number of participants: ");
        int count = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (int i = 1; i <= count; i++) {
            System.out.print("Enter name of participant " + i + ": ");
            String name = sc.nextLine();

            System.out.print("Enter age of participant " + i + ": ");
            int age = sc.nextInt();
            sc.nextLine(); // Consume newline

            batch.addParticipant(new ZumbaParticipant(name, age));
        }

        // Start Batch
        batch.startBatch();

        sc.close();
    }
}
