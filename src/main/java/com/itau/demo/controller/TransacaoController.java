package com.itau.demo.controller;

import com.itau.demo.dto.TransacaoRequest;
import com.itau.demo.service.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @Operation(
            summary = "Registra uma nova transação",
            description = "Recebe 'valor' e 'datahora'. Valida se é uma transação válida.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Transação aceita"),
                    @ApiResponse(responseCode = "422", description = "Transação inválida"),
                    @ApiResponse(responseCode = "201", description = "JSON iválido"),
            }
    )
    public ResponseEntity<Void> addTransacao(@RequestBody TransacaoRequest transacao) {
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
    @Operation(
            summary = "Deleta Todas as transações"
    )
    public ResponseEntity<Void> delTransacao() {
        transacaoService.delTransacoes();
        return ResponseEntity.noContent().build();
    }
}
