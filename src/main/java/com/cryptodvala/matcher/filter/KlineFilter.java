package com.cryptodvala.matcher.filter;

import com.cryptodvala.matcher.dto.Kline;

import java.util.List;

public interface KlineFilter {
    boolean check(List<Kline> candlesticks);
}
