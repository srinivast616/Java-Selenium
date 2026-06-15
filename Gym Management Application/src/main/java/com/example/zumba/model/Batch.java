package com.example.zumba.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String timing; // e.g., Morning/Evening

    @OneToMany(mappedBy = "batch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Participant> participants = new ArrayList<>();

    public Batch() {}
    public Batch(String name, String timing) {
        this.name = name; this.timing = timing;
    }

    // getters/setters

    public Long getId(){ return id; }
    public String getName(){ return name; }
    public String getTiming(){ return timing; }
    public List<Participant> getParticipants(){ return participants; }

    public void addParticipant(Participant p){
        p.setBatch(this);
        participants.add(p);
    }
}
