package com.cryptodvala.matcher.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor @NoArgsConstructor
@Table(name = "kline_predictions")
public class KlinePrediction implements Persistable<LocalDateTime>, Serializable {
    @Id
    private LocalDateTime dateTime;
    private String exchangeSymbol;
    private boolean isSuccessful;

    @Override
    public LocalDateTime getId() {
        return this.dateTime;
    }

    @Override
    public boolean isNew() {
        return this.dateTime == null;
    }
}
