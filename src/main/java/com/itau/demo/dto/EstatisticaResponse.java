package com.itau.demo.dto;

import java.math.BigDecimal;

public record EstatisticaResponse(
        long count,
        BigDecimal sum,
        BigDecimal avg,
        BigDecimal min,
        BigDecimal max) {
    public EstatisticaResponse(long count, BigDecimal sum, BigDecimal avg, BigDecimal min, BigDecimal max) {
        this.count = count;
        this.sum = sum;
        this.avg = avg;
        this.min = min;
        this.max = max;
    }
}
