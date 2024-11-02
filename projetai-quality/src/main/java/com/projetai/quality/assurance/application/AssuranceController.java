package com.projetai.quality.assurance.application;

import com.projetai.quality.assurance.application.dto.AssuranceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assurance")
public class AssuranceController {
    private final AssuranceService assuranceService;

    @Autowired
    public AssuranceController(AssuranceService assuranceService) {
        this.assuranceService = assuranceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssuranceDto> findAssuranceById(@PathVariable Long id) {
        return ResponseEntity.ok(new AssuranceDto(assuranceService.findAssurance(id)));
    }

    @GetMapping("/assurances")
    public ResponseEntity<Page<AssuranceDto>> findAllAssurance(@PageableDefault(sort = {"AssuranceStatus"}) Pageable pageable) {
        return ResponseEntity.ok(assuranceService.findAllAssurance(pageable));
    }

    @PostMapping("/start-assurance")
    public ResponseEntity<String> startAssurance(@RequestBody AssuranceDto assuranceDto) {
        assuranceService.startAssurance(assuranceDto);
        return ResponseEntity.ok("Assurance started");
    }

    @PostMapping("/complete-assurance")
    public ResponseEntity<String> completeAssurance(@RequestBody AssuranceDto assuranceDto) {
        assuranceService.completeAssurance(assuranceDto);
        return ResponseEntity.ok("Assurance completed");
    }
}
