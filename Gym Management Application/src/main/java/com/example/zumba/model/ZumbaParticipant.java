package com.example.zumba.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ZUMBA")
public class ZumbaParticipant extends Participant {

    public ZumbaParticipant() { super(); }

    public ZumbaParticipant(String name, int age, String contact) {
        super(name, age, contact);
    }

    @Override
    public void notifyBatchStart(String batchName) {
        // customized notification
        System.out.println("Hey " + getName() + "! Your Zumba batch '" + batchName + "' is starting now! Time to groove.");
    }
}
