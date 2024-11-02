package com.projetai.development.refinement.application.refinement;

import com.projetai.development.refinement.application.dto.RefinementDto;
import com.projetai.development.refinement.application.dto.TechLeadDto;
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

    @PostMapping("/createTechLead")
    public ResponseEntity<TechLeadDto> createTechLead(@RequestBody TechLeadDto techLeadDto) {
        return ResponseEntity.ok(refinementService.createTechLead(techLeadDto));
    }

    @PostMapping("/startRefinement")
    public ResponseEntity<String> startRefinement(@RequestBody RefinementDto refinementDto) {
        refinementService.startRefinement(refinementDto);
        return ResponseEntity.ok("Refinement started");
    }

    @PostMapping("/completeRefinement")
    public ResponseEntity<String> completeRefinement(@RequestBody RefinementDto refinementDto) {
        refinementService.completeRefinement(refinementDto);
        return ResponseEntity.ok("Refinement started");
    }

}
