package com.cryptodvala.matcher.filter;

import com.cryptodvala.matcher.dto.Kline;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestFilter implements KlineFilter {
    @Override
    public boolean check(List<Kline> candlesticks) {
        return false;
    }
}
