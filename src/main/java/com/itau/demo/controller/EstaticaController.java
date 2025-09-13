package com.itau.demo.controller;

import com.itau.demo.dto.EstatisticaResponse;
import com.itau.demo.service.EstatisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
{
  "count": 10,
  "sum": 1234.56,
  "avg": 123.45,
  "min": 12.34,
  "max": 200.00
}
 */

@RestController
@RequestMapping("/estatistica")
public class EstaticaController {

    private EstatisticaService estatisticaService;

    public EstaticaController(EstatisticaService estatisticaService){
        this.estatisticaService = estatisticaService;
    }

    @GetMapping
    public ResponseEntity<EstatisticaResponse> getEstatistica(){
        EstatisticaResponse estatisticaResponse = estatisticaService.calcularEstatistica();
        return ResponseEntity.ok(estatisticaResponse);
    }
}
