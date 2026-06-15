package com.example.zumba.web;

import com.example.zumba.model.Batch;
import com.example.zumba.model.Participant;
import com.example.zumba.model.ZumbaParticipant;
import com.example.zumba.repository.BatchRepository;
import com.example.zumba.repository.ParticipantRepository;
import com.example.zumba.service.BatchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//Controller & UI (Thymeleaf)
@Controller
public class WebController {
    private final BatchRepository batchRepo;
    private final ParticipantRepository participantRepo;
    private final BatchService batchService;

    public WebController(BatchRepository batchRepo, ParticipantRepository participantRepo, BatchService batchService) {
        this.batchRepo = batchRepo;
        this.participantRepo = participantRepo;
        this.batchService = batchService;
    }

    @GetMapping("/")
    public String index(Model m) {
        m.addAttribute("batches", batchRepo.findAll());
        return "index";
    }

    @GetMapping("/batch/new")
    public String newBatchForm(Model m) {
        m.addAttribute("batch", new Batch());
        return "batch_form";
    }

    @PostMapping("/batch")
    public String createBatch(@RequestParam String name, @RequestParam String timing) {
        batchService.createBatch(name, timing);
        return "redirect:/";
    }

    @GetMapping("/batch/{id}")
    public String viewBatch(@PathVariable Long id, Model m) {
        Batch b = batchRepo.findById(id).orElseThrow();
        m.addAttribute("batch", b);
        return "batch_view";
    }

    @PostMapping("/batch/{id}/participant")
    public String addParticipant(@PathVariable Long id,
                                 @RequestParam String name,
                                 @RequestParam int age,
                                 @RequestParam String contact) {
        Participant p = new ZumbaParticipant(name, age, contact); // could choose different participant types
        batchService.addParticipant(id, p);
        return "redirect:/batch/" + id;
    }

    @PostMapping("/batch/{id}/start")
    public String startBatch(@PathVariable Long id, Model m) {
        batchService.startBatch(id);
        // after start, redirect to batch view - notifications printed in server logs
        return "redirect:/batch/" + id;
    }
}
