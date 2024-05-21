package com.cryptodvala.matcher.processor;

import com.cryptodvala.matcher.filter.KlineFilter;
import reactor.core.publisher.Flux;

public interface ReactiveKlineFilterProcessor<T> extends KlineFilterProcessor<Flux<T>> {
    Flux<KlineFilter> getKlineFilters();
}
