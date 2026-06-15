package com.gym.management;

import java.util.ArrayList;
import java.util.List;

//===== Batch Class (1-to-Many Relationship) =====
class Batch {
 private String batchName;
 private String timing;
 private List<Participant> participants;

 public Batch(String batchName, String timing) {
     this.batchName = batchName;
     this.timing = timing;
     this.participants = new ArrayList<>();
 }

 public void addParticipant(Participant participant) {
     participants.add(participant);
 }

 public void startBatch() {
     System.out.println("\nBatch '" + batchName + "' starting at " + timing + "...");
     for (Participant p : participants) {
         p.notifyBatchStart(batchName); // Runtime polymorphism in action
     }
 }
}

