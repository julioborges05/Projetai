package com.projetai.core.application;

import com.projetai.core.application.dto.SupportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/support")
public class SupportController {

    private final SupportService supportService;

    @Autowired
    public SupportController(SupportService supportService) {
        this.supportService = supportService;
    }

    @GetMapping
    public ResponseEntity<List<SupportDto>> findAllSupports() {
        return ResponseEntity.ok(supportService.findAllSupports());
    }

    @PostMapping
    public ResponseEntity<SupportDto> createSupport(@RequestBody SupportDto supportDto) {
        return ResponseEntity.ok(supportService.createSupport(supportDto));
    }

}
