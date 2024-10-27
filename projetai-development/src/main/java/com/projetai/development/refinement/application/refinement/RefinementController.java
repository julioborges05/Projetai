package com.projetai.development.refinement.application.refinement;

import com.projetai.development.refinement.application.dto.RefinementDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/refinement")
public class RefinementController {

    private final RefinementService refinementService;

    public RefinementController(RefinementService refinementService) {
        this.refinementService = refinementService;
    }

    @PostMapping
    @RequestMapping("/start-refinement")
    public ResponseEntity<String> startRefinement(@RequestBody RefinementDto refinementDto) {
        refinementService.startRefinement(refinementDto);
        return ResponseEntity.ok("Refinement started");
    }

    @PostMapping
    @RequestMapping("/complete-refinement")
    public ResponseEntity<String> completeRefinement(@RequestBody RefinementDto refinementDto) {
        refinementService.completeRefinement(refinementDto);
        return ResponseEntity.ok("Refinement started");
    }

}
