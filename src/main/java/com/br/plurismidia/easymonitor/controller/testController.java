package com.br.plurismidia.easymonitor.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
@EnableAutoConfiguration
@Tag(name = "API Test", description = "Endpoints para teste de integridade da aplicação")
public class testController {

    @Operation(summary = "Teste GET para verificação de status")
    @CrossOrigin
    @GetMapping("getstatusapp")
    public String getStatusApp() {
        System.gc();
        return "{\"status\":\"up\"}";
    }

    @Operation(summary = "Teste POST para verificação de status")
    @CrossOrigin
    @PostMapping(value = "poststatusapp")
    public String postStatusApp() {
        System.gc();
        return "{\"status\":\"up\"}";
    }
}
