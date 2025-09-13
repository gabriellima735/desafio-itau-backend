package com.itau.demo.controller;

import com.itau.demo.dto.EstatisticaResponse;
import com.itau.demo.service.EstatisticaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstaticaController {

    @Autowired
    private EstatisticaService estatisticaService;

    @GetMapping
    @Operation(
            summary = "Restorna as estatísticas das transações dos últimos 60 segundos"
    )
    public ResponseEntity<EstatisticaResponse> getEstatistica(){
        EstatisticaResponse estatisticaResponse = estatisticaService.calcularEstatistica();
        return ResponseEntity.ok(estatisticaResponse);
    }
}
