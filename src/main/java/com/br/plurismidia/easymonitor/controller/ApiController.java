package com.br.plurismidia.easymonitor.controller;

import com.br.plurismidia.easymonitor.bean.entity.Api;
import com.br.plurismidia.easymonitor.service.ApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitor/api")
@RequiredArgsConstructor
@Tag(name = "API Management", description = "Operações de gerenciamento de APIs monitoradas")
public class ApiController {

    private final ApiService service;

    @Operation(summary = "Retorna todas as APIs cadastradas")
    @GetMapping
    public List<Api> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Cadastra uma nova API")
    @PostMapping
    public Api save(@RequestBody Api api) {
        return service.save(api);
    }

    @Operation(summary = "Atualiza dados de uma API existente")
    @PutMapping("/{id}")
    public Api update(@PathVariable Long id, @RequestBody Api novaApi) {
        return service.update(id, novaApi);
    }

    @Operation(summary = "Remove uma API pelo ID")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
