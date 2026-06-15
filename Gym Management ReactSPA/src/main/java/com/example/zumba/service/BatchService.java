package com.example.zumba.service;

import com.example.zumba.model.Batch;
import com.example.zumba.model.Participant;
import com.example.zumba.repository.BatchRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//performs startBatch logic
@Service
public class BatchService {
    private final BatchRepository batchRepository;

    public BatchService(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    public Batch createBatch(String name, String timing) {
        Batch b = new Batch(name, timing);
        return batchRepository.save(b);
    }

    @Transactional
    public void addParticipant(Long batchId, Participant p) {
        Batch b = batchRepository.findById(batchId).orElseThrow();
        b.addParticipant(p);
        batchRepository.save(b);
    }

    @Transactional
    public void startBatch(Long batchId) {
        Batch b = batchRepository.findById(batchId).orElseThrow();
        // runtime polymorphism: participant may be ZumbaParticipant etc.
        for (Participant p : b.getParticipants()) {
            p.notifyBatchStart(b.getName());
            // optionally persist a Notification entity or log - omitted for brevity
        }
    }
}
