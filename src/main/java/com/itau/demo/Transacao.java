package com.itau.demo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Transacao {

    @NotNull
    @PositiveOrZero
    private BigDecimal valor;

    @NotNull
    private OffsetDateTime dataHora;

}
