package com.itau.demo.service;

import com.itau.demo.controller.EstaticaController;
import com.itau.demo.dto.EstatisticaResponse;
import com.itau.demo.model.TransacaoModel;
import com.itau.demo.repository.interfaces.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class EstatisticaService {

    private TransacaoRepository transacaoRepository;

    public EstatisticaService(TransacaoRepository transacaoRepository){
        this.transacaoRepository = transacaoRepository;
    }

    public EstatisticaResponse calcularEstatistica() {
        OffsetDateTime limite = OffsetDateTime.now().minusSeconds(60);
//        System.out.println(limite.getMinute() + " " + OffsetDateTime.now().getMinute());
        List<TransacaoModel> recentes = transacaoRepository
                .findAll()
                .stream()
                .filter(t -> t.getDataHora().isAfter(limite))
                .toList()
                ;
        System.out.println("adfsasd " + recentes);
        if(recentes.isEmpty()){
            return new EstatisticaResponse(
                    0, BigDecimal.ZERO,
                    BigDecimal.ZERO, BigDecimal.ZERO,
                    BigDecimal.ZERO
            );
        }
        DoubleSummaryStatistics stats = recentes.stream()
                .mapToDouble(t -> t.getValor().doubleValue())
                .summaryStatistics();

        return new EstatisticaResponse(
                stats.getCount(),
                BigDecimal.valueOf(stats.getSum()),
                BigDecimal.valueOf(stats.getAverage()),
                BigDecimal.valueOf(stats.getMin()),
                BigDecimal.valueOf(stats.getMax())
        );
    }
}
