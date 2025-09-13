package com.itau.demo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class TransacaoDto {

    @NotNull
    @PositiveOrZero
    private BigDecimal valor;

    @NotNull
    private OffsetDateTime dataHora;


}

