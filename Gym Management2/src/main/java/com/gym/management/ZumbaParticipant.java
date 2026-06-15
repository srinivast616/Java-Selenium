package com.gym.management;

//===== Subclass to demonstrate runtime polymorphism =====
class ZumbaParticipant extends Participant {
 public ZumbaParticipant(String name, int age) {
     super(name, age);
 }

 @Override
 public void notifyBatchStart(String batchName) {
     System.out.println("Hey " + getName() + "! Your Zumba batch '" + batchName + "' is starting now! Let's dance!");
 }
}