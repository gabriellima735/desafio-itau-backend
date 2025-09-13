package com.itau.demo.repository.inMemory;

import com.itau.demo.model.TransacaoModel;
import com.itau.demo.repository.interfaces.TransacaoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class TransacaoRepositoryInMemory implements TransacaoRepository {
    private static List<TransacaoModel> transacoes = new CopyOnWriteArrayList<>();

    @Override
    public void save(TransacaoModel transacaoModel) {
        transacoes.add(transacaoModel);
        auxPrint();
    }

    @Override
    public List<TransacaoModel> findAll() {
        System.out.println("Retorna");
        auxPrint();
        return transacoes;
    }

    @Override
    public void deleteAll() {
        transacoes.clear();
        auxPrint();
    }

    private void auxPrint(){
        System.out.println("###");
        System.out.println(transacoes.toString());
        for(TransacaoModel t:transacoes){
            System.out.println(
                    t.toString()
            );
        }
        System.out.println("###");
    }
}
