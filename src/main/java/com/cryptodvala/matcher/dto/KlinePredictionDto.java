package com.cryptodvala.matcher.dto;

import com.cryptodvala.matcher.entity.KlinePrediction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor @NoArgsConstructor
public class KlinePredictionDto implements Serializable {
    private LocalDateTime dateTime;
    private String exchangeSymbol;
    private boolean isSuccessful;

    public static KlinePredictionDto fromKlinePrediction(KlinePrediction klinePrediction) {
        return KlinePredictionDto.builder()
                .dateTime(klinePrediction.getDateTime())
                .exchangeSymbol(klinePrediction.getExchangeSymbol())
                .isSuccessful(klinePrediction.isSuccessful())
                .build();
    }

    public KlinePrediction toKlinePrediction() {
        return KlinePrediction.builder()
                .dateTime(this.getDateTime())
                .exchangeSymbol(this.getExchangeSymbol())
                .isSuccessful(this.isSuccessful())
                .build();
    }
}
