package com.cryptodvala.matcher.service.impl;

import com.cryptodvala.matcher.dto.Kline;
import com.cryptodvala.matcher.dto.KlinePredictionDto;
import com.cryptodvala.matcher.dto.MatcherRequest;
import com.cryptodvala.matcher.entity.KlinePrediction;
import com.cryptodvala.matcher.filter.KlineFilter;
import com.cryptodvala.matcher.repository.KlinePredictionRepository;
import com.cryptodvala.matcher.service.MatcherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatcherServiceImpl implements MatcherService {
    private final WebClient webClient;
    private final KlineFilter starterFilter;
    private final KlinePredictionRepository klinePredictionRepository;

    @Override
    public Mono<KlinePredictionDto> createFilteredKlinePrediction(MatcherRequest request) {
        List<Kline> candlesticks = webClient.get()
                .uri("https://fapi.binance.com/fapi/v1/klines")
                .header("symbol", request.getSymbol())
                .header("interval", request.getInterval())
                .retrieve()
                .bodyToFlux(Number[].class)
                .cache()
                .map(numbers -> Kline.builder()
                        .openTime(numbers[0].longValue())
                        .openPrice(numbers[1].floatValue())
                        .highPrice(numbers[2].floatValue())
                        .lowPrice(numbers[3].floatValue())
                        .closePrice(numbers[4].floatValue())
                        .volume(numbers[5].floatValue())
                        .closeTime(numbers[6].longValue())
                        .quoteAssetVolume(numbers[7].floatValue())
                        .tradeCount(numbers[8].shortValue())
                        .takerBuyBaseAssetVolume(numbers[9].floatValue())
                        .takerBuyQuoteAssetVolume(numbers[10].floatValue())
                        .build())
                .collectList()
                .block();
        boolean isSuccessful = starterFilter.check(candlesticks);
        return klinePredictionRepository.save(new KlinePrediction(LocalDateTime.now(), request.getSymbol(), isSuccessful))
                .map(KlinePredictionDto::fromKlinePrediction);
    }
}
