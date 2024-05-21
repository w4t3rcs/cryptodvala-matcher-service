package com.cryptodvala.matcher.filter;

import com.cryptodvala.matcher.dto.Kline;
import org.springframework.stereotype.Component;

@Component
public class TestFilter implements KlineFilter {
    @Override
    public boolean check(Iterable<Kline> klines) {
        return false;
    }
}
