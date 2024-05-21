package com.cryptodvala.matcher.filter;

import com.cryptodvala.matcher.dto.Kline;

public interface KlineFilter {
    boolean check(Iterable<Kline> klines);
}
