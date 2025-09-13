package com.itau.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class TransacaoRequest {

    @NotNull
    @PositiveOrZero
    @Schema(description = "Valor da transação", example = "123.45")
    private BigDecimal valor;

    @NotNull
    @Schema(description = "Data e Hora da transação" , example = "2025-09-12T17:00:00-03:00")
    private OffsetDateTime dataHora;


}

