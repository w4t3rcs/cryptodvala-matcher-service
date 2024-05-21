package com.cryptodvala.matcher.processor;

import com.cryptodvala.matcher.dto.Kline;

public interface KlineFilterProcessor<T> {
    T process(Iterable<Kline> klines);
}
