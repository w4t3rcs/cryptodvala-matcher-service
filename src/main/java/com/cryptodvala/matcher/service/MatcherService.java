package com.cryptodvala.matcher.service;

import com.cryptodvala.matcher.dto.KlinePredictionDto;
import com.cryptodvala.matcher.dto.MatcherRequest;
import reactor.core.publisher.Mono;

public interface MatcherService {
    Mono<KlinePredictionDto> createFilteredKlinePrediction(MatcherRequest request);
}
