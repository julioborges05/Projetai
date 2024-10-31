package com.projetai.quality.assurance.application;

import com.projetai.quality.assurance.application.dto.AssuranceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assurance")
public class AssuranceController {
    private final AssuranceService assuranceService;

    public AssuranceController(AssuranceService assuranceService) {
        this.assuranceService = assuranceService;
    }

    @PostMapping
    @RequestMapping("/start-assurance")
    public ResponseEntity<String> startAssurance(@RequestBody AssuranceDto assuranceDto) {
        assuranceService.startAssurance(assuranceDto);
        return ResponseEntity.ok("Assurance started");
    }

    @PostMapping
    @RequestMapping("/complete-assurance")
    public ResponseEntity<String> completeAssurance(@RequestBody AssuranceDto assuranceDto) {
        assuranceService.completeAssurance(assuranceDto);
        return ResponseEntity.ok("Assurance completed");
    }
}
