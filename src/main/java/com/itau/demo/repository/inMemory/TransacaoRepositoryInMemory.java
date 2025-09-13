package com.itau.demo.repository.inMemory;

import com.itau.demo.model.TransacaoModel;
import com.itau.demo.repository.interfaces.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class TransacaoRepositoryInMemory implements TransacaoRepository {
    private static final Logger log = LoggerFactory.getLogger(TransacaoRepositoryInMemory.class);

    private static List<TransacaoModel> transacoes = new CopyOnWriteArrayList<>();

    @Override
    public void save(TransacaoModel transacaoModel) {
        transacoes.add(transacaoModel);
        log.info("Transação Adicionada");
    }

    @Override
    public List<TransacaoModel> findAll() {
        log.info("Transações retornadas");
        return transacoes;
    }

    @Override
    public void deleteAll() {
        transacoes.clear();
        log.info("Transações Limpas");
    }

}
