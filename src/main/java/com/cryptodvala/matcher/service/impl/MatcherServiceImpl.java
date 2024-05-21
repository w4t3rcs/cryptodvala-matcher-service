package com.cryptodvala.matcher.service.impl;

import com.cryptodvala.matcher.binance.KlinesLoader;
import com.cryptodvala.matcher.dto.Kline;
import com.cryptodvala.matcher.dto.KlinePredictionDto;
import com.cryptodvala.matcher.dto.MatcherRequest;
import com.cryptodvala.matcher.entity.KlinePrediction;
import com.cryptodvala.matcher.processor.ReactiveKlineFilterProcessor;
import com.cryptodvala.matcher.repository.KlinePredictionRepository;
import com.cryptodvala.matcher.service.MatcherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class MatcherServiceImpl implements MatcherService {
    private final KlinesLoader klinesLoader;
    private final ReactiveKlineFilterProcessor<Boolean> klineFilterProcessor;
    private final KlinePredictionRepository klinePredictionRepository;

    @Override
    public Mono<KlinePredictionDto> createFilteredKlinePrediction(MatcherRequest request) {
        Iterable<Kline> klines = klinesLoader.getKlines(request);
        Stream<Boolean> results = klineFilterProcessor.process(klines).toStream();
        return klinePredictionRepository.save(new KlinePrediction(LocalDateTime.now(), request.getSymbol(), results.anyMatch(aBoolean -> aBoolean)))
                .map(KlinePredictionDto::fromKlinePrediction);
    }
}
