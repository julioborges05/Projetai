package com.projetai.development.develop.application;

import com.projetai.development.develop.application.dto.DeveloperDto;
import com.projetai.development.develop.application.dto.DevelopmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/develop")
public class DevelopmentController {

    private final DevelopmentService developmentService;

    @Autowired
    public DevelopmentController(DevelopmentService developmentService) {
        this.developmentService = developmentService;
    }

    @PostMapping
    @RequestMapping("/createDeveloper")
    public ResponseEntity<DeveloperDto> createDeveloper(@RequestBody DeveloperDto developerDto) {
        return ResponseEntity.ok(developmentService.createDeveloper(developerDto));
    }

    @PostMapping
    @RequestMapping("/startDevelopment")
    public ResponseEntity<String> startDevelopment(@RequestBody DevelopmentDto developmentDto) {
        developmentService.startDevelopment(developmentDto);
        return ResponseEntity.ok("Development started");
    }

    @PutMapping
    @RequestMapping("/addDetailsDevelopment")
    public ResponseEntity<String> addDetails(@RequestBody DevelopmentDto developmentDto) {
        developmentService.addDetails(developmentDto);
        return ResponseEntity.ok("Development details added");
    }

    @PostMapping
    @RequestMapping("/completeDevelopment")
    public ResponseEntity<String> completeDevelopment(@RequestBody DevelopmentDto developmentDto) {
        developmentService.completeDevelopment(developmentDto);
        return ResponseEntity.ok("Development completed");
    }

}
