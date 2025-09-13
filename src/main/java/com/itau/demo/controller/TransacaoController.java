package com.itau.demo.controller;

import com.itau.demo.dto.TransacaoDto;
import com.itau.demo.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

/**
 {
 "valor": 200.00,
 "dataHora": "2025-09-12T17:00:00-03:00"
 }
 */

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<Void> addTransacao(@RequestBody TransacaoDto transacao) {
        try {
            transacaoService.addTransacao(transacao);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException e){
            return ResponseEntity.unprocessableEntity().build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> delTransacao() {
        transacaoService.delTransacoes();
        return ResponseEntity.noContent().build();
    }
}
