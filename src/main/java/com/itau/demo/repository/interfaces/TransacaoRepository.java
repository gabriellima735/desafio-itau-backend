package com.itau.demo.repository.interfaces;

import com.itau.demo.model.TransacaoModel;

import java.util.List;

public interface TransacaoRepository {
    void save(TransacaoModel transacaoModel);
    List<TransacaoModel> findAll();
    void deleteAll();
}
