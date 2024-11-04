package com.projetai.development.develop.application;

import com.projetai.development.develop.application.dto.CommentDto;
import com.projetai.development.develop.application.dto.DeveloperDto;
import com.projetai.development.develop.application.dto.DevelopmentDto;
import com.projetai.development.develop.application.dto.EstimatedHoursDto;
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

    @PostMapping("/addEstimatedHours")
    public ResponseEntity<String> addEstimatedHours(@RequestBody EstimatedHoursDto estimatedHoursDto) {
        developmentService.addEstimatedHours(estimatedHoursDto);
        return ResponseEntity.ok("Hours estimated");
    }

    @PostMapping("/createDeveloper")
    public ResponseEntity<DeveloperDto> createDeveloper(@RequestBody DeveloperDto developerDto) {
        return ResponseEntity.ok(developmentService.createDeveloper(developerDto));
    }

    @PostMapping("/addDetails")
    public ResponseEntity<String> addDetailsToTicket(@RequestBody CommentDto commentDto) {
        developmentService.addDetailsToTicket(commentDto);
        return ResponseEntity.ok("Comment added");
    }

    @PostMapping("/startDevelopment")
    public ResponseEntity<String> startDevelopment(@RequestBody DevelopmentDto developmentDto) {
        developmentService.startDevelopment(developmentDto);
        return ResponseEntity.ok("Development started");
    }

    @PostMapping("/completeDevelopment")
    public ResponseEntity<String> completeDevelopment(@RequestBody DevelopmentDto developmentDto) {
        developmentService.completeDevelopment(developmentDto);
        return ResponseEntity.ok("Development completed");
    }

}
