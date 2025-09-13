package com.itau.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class TransacaoModel {
    private BigDecimal valor;
    private OffsetDateTime dataHora;

    public TransacaoModel(BigDecimal valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "TransacaoModel{" +
                "valor=" + valor +
                ", HORA=" + dataHora.getHour() + ", MINUTO=" + dataHora.getMinute() +
                '}';
    }
}
