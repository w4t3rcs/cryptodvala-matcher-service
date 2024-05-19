package com.cryptodvala.matcher.service;

import com.cryptodvala.matcher.dto.KlinePredictionDto;
import reactor.core.publisher.Mono;

public interface MatcherService {
    Mono<KlinePredictionDto> createFilteredKlinePrediction(String symbol, String interval);
}
