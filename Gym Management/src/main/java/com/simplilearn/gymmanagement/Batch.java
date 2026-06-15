package com.simplilearn.gymmanagement;

import java.util.ArrayList;
import java.util.List;

public class Batch {
	private String batchName;
	private String batchTime;
	private List<Participant> participants;

	public Batch(String batchName, String batchTime) {
		this.batchName = batchName;
		this.batchTime = batchTime;
		this.participants = new ArrayList<>();
	}

	public void addParticipant(Participant participant) {
		participants.add(participant);
	}

	public void startBatch() {
		System.out.println("\n=== Batch " + batchName + " (" + batchTime + ") is starting! ===");
		for (Participant p : participants) {
			p.onBatchStart(batchName);
		}
	}

	@Override
	public String toString() {
		return "Batch{" + "batchName='" + batchName + '\'' + ", batchTime='" + batchTime + '\'' + ", participants="
				+ participants + '}';
	}
}
