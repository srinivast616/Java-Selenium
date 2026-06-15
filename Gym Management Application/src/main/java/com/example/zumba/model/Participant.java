package com.example.zumba.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "participant_type")
public abstract class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String contact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batch_id")
    private Batch batch;

    // constructors, getters, setters

    public Participant() {}

    public Participant(String name, int age, String contact) {
        this.name = name;
        this.age = age;
        this.contact = contact;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getContact() { return contact; }
    public Batch getBatch() { return batch; }
    public void setBatch(Batch b) { this.batch = b; }

    // runtime polymorphic callback
    public void notifyBatchStart(String batchName) {
        // default implementation
        System.out.println("Hello " + name + ", your batch " + batchName + " has started.");
    }
}
