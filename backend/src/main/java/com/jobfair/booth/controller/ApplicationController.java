package com.jobfair.booth.controller;

import com.jobfair.booth.model.Application;
import com.jobfair.booth.model.Booth;
import com.jobfair.booth.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    // 신청 등록
    @PostMapping
    public ResponseEntity<?> apply(
            @RequestBody Application application,
            @RequestParam Long boothId
    ) {
        try {
            Application saved = applicationService.register(application, boothId);
            return ResponseEntity.ok(saved);
        } catch (IllegalStateException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 전체 신청자 조회 (관리자용)
    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications() {
        return ResponseEntity.ok(applicationService.findAll());
    }

    // 부스 목록 조회
    @GetMapping("/booths")
    public ResponseEntity<List<Booth>> getAllBooths() {
        return ResponseEntity.ok(applicationService.getAllBooths());
    }
}
