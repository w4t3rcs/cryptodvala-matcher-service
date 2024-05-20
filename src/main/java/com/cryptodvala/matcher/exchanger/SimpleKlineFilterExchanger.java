package com.cryptodvala.matcher.exchanger;

import com.cryptodvala.matcher.filter.KlineFilter;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@RequiredArgsConstructor
public class SimpleKlineFilterExchanger implements KlineFilterExchanger {
    private final List<KlineFilter> klineFilters;

    @Override
    public void process() {
        //
    }
}
