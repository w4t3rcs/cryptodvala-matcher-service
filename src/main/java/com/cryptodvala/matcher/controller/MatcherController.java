package com.cryptodvala.matcher.controller;

import com.cryptodvala.matcher.dto.KlinePredictionDto;
import com.cryptodvala.matcher.dto.MatcherRequest;
import com.cryptodvala.matcher.service.MatcherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/matcher")
@RequiredArgsConstructor
public class MatcherController {
    private final MatcherService matcherService;

    @PostMapping
    public ResponseEntity<Mono<KlinePredictionDto>> postFilteredKlinePrediction(@RequestBody MatcherRequest request) {
        return ResponseEntity.ok(matcherService.createFilteredKlinePrediction(request));
    }
}
