package com.cryptodvala.matcher.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Kline implements Serializable {
    private long openTime;
    private float openPrice;
    private float highPrice;
    private float lowPrice;
    private float closePrice;
    private float volume;
    private long closeTime;
    private float quoteAssetVolume;
    private short tradeCount;
    private float takerBuyBaseAssetVolume;
    private float takerBuyQuoteAssetVolume;
}
