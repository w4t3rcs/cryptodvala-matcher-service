package com.cryptodvala.matcher.repository;

import com.cryptodvala.matcher.entity.KlinePrediction;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import java.time.LocalDateTime;

public interface KlinePredictionRepository extends R2dbcRepository<KlinePrediction, LocalDateTime> {
}
