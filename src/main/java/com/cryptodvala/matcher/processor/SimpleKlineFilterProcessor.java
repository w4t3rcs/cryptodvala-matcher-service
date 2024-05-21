package com.cryptodvala.matcher.processor;

import com.cryptodvala.matcher.dto.Kline;
import com.cryptodvala.matcher.filter.KlineFilter;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Data
@Component
@RequiredArgsConstructor
public class SimpleKlineFilterProcessor implements ReactiveKlineFilterProcessor<Boolean> {
    private final KlineFilter starterFilter;

    @Override
    public Flux<KlineFilter> getKlineFilters() {
        return Flux.just(
                starterFilter
        );
    }

    @Override
    public Flux<Boolean> process(Iterable<Kline> klines) {
        return getKlineFilters()
                .map(klineFilter -> klineFilter.check(klines))
                .distinct();
    }
}
