package com.cryptodvala.matcher.exchanger;

import com.cryptodvala.matcher.filter.KlineFilter;

import java.util.List;

public interface KlineFilterExchanger {
    List<KlineFilter> getKlineFilters();

    void process();
}
