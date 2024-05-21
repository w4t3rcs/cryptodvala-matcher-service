package com.cryptodvala.matcher.binance;

import com.cryptodvala.matcher.dto.Kline;
import com.cryptodvala.matcher.dto.MatcherRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class BinanceKlinesLoader implements KlinesLoader {
    private final WebClient webClient;

    @Override
    public Iterable<Kline> getKlines(MatcherRequest request) {
        return webClient.get()
                .uri("https://fapi.binance.com/fapi/v1/klines")
                .header("symbol", request.getSymbol())
                .header("interval", request.getInterval())
                .retrieve()
                .bodyToFlux(Number[][].class)
                .cache()
                .flatMap(numbers -> Flux.fromArray(numbers)
                        .map(row -> Kline.builder()
                        .openTime(row[0].longValue())
                        .openPrice(row[1].floatValue())
                        .highPrice(row[2].floatValue())
                        .lowPrice(row[3].floatValue())
                        .closePrice(row[4].floatValue())
                        .volume(row[5].floatValue())
                        .closeTime(row[6].longValue())
                        .quoteAssetVolume(row[7].floatValue())
                        .tradeCount(row[8].shortValue())
                        .takerBuyBaseAssetVolume(row[9].floatValue())
                        .takerBuyQuoteAssetVolume(row[10].floatValue())
                        .build()))

                .toIterable();
    }
}
