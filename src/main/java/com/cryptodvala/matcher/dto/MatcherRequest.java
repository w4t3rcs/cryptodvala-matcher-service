package com.cryptodvala.matcher.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class MatcherRequest {
    private String symbol;
    private String interval;
}
