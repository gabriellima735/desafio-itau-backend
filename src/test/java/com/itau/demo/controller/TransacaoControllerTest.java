package com.itau.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TransacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testTransacaoValida() throws Exception {
        String json = "{\"valor\":100.0,\"dataHora\":\"2025-09-13T14:00:00-03:00\"}";
        mockMvc.perform(post("/transacao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated()
        );
    }

    @Test
    void testTransacaoValorNegativo() throws Exception {
        String json = "{\"valor\":-10.0,\"dataHora\":\"2025-09-13T14:00:00-03:00\"}";

        mockMvc.perform(post("/transacao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isUnprocessableEntity());
    }

}
