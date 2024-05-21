package com.cryptodvala.matcher.navigator;

import com.cryptodvala.matcher.filter.KlineFilter;

import java.util.List;

public interface KlineFilterNavigator {
    List<KlineFilter> getKlineFilters();

    void navigate();
}
