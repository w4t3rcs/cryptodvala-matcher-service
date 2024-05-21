package com.cryptodvala.matcher.binance;

import com.cryptodvala.matcher.dto.Kline;
import com.cryptodvala.matcher.dto.MatcherRequest;

import java.util.List;

public interface KlinesLoader {
    Iterable<Kline> getKlines(MatcherRequest request);
}
