package com.cryptodvala.matcher.navigator;

import com.cryptodvala.matcher.filter.KlineFilter;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@RequiredArgsConstructor
public class SimpleKlineFilterNavigator implements KlineFilterNavigator {
    private final List<KlineFilter> klineFilters;

    @Override
    public void navigate() {
        //
    }
}
