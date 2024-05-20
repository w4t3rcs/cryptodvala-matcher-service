package com.cryptodvala.matcher.actuator;

import com.cryptodvala.matcher.filter.KlineFilter;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Endpoint(id = "kline-filters")
public class KlineFilterEndpoint {
    private final List<KlineFilter> klineFilters = new ArrayList<>();

    @ReadOperation
    public List<KlineFilter> getKlineFilters() {
        return klineFilters;
    }

    @ReadOperation
    public KlineFilter getKlineFilter(@Selector Integer id) {
        return klineFilters.get(id);
    }
}
