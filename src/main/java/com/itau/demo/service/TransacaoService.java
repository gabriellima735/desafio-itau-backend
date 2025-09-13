package com.itau.demo.service;

import com.itau.demo.dto.TransacaoDto;
import com.itau.demo.model.TransacaoModel;
import com.itau.demo.repository.interfaces.TransacaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {
    private final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public void addTransacao(TransacaoDto transacaoDto){
        OffsetDateTime agora = OffsetDateTime.now();
        if (transacaoDto.getValor().compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Valor não pode ser menor que 0!");
        }
        if (transacaoDto.getDataHora().isAfter(agora)){
            throw new IllegalArgumentException("Data não poder estar no futuro!");
        }

        TransacaoModel transacaoModel = new TransacaoModel(transacaoDto.getValor(), transacaoDto.getDataHora());
        transacaoRepository.save(transacaoModel);
    }

    public void delTransacoes(){
        transacaoRepository.deleteAll();
    }


}
