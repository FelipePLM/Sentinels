package com.github.felipeplm.api.controller;

import com.github.felipeplm.api.entity.MonitoredApi;
import com.github.felipeplm.api.service.ApiMonitoringService;
import com.github.felipeplm.api.service.MonitoredApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitor/api")
@RequiredArgsConstructor
@Tag(name = "API Management", description = "Operações de gerenciamento e monitoramento de APIs")
public class ApiController {

    private final MonitoredApiService apiService;
    private final ApiMonitoringService monitoringService;

    @Operation(summary = "Retorna todas as APIs cadastradas")
    @GetMapping
    public List<MonitoredApi> findAll() {
        return apiService.findAll();
    }

    @Operation(summary = "Cadastra uma nova API")
    @PostMapping
    public MonitoredApi save(@RequestBody MonitoredApi api) {
        return apiService.save(api);
    }

    @Operation(summary = "Atualiza dados de uma API existente")
    @PutMapping("/{id}")
    public MonitoredApi update(@PathVariable Long id, @RequestBody MonitoredApi updatedApi) {
        return apiService.update(id, updatedApi);
    }

    @Operation(summary = "Remove uma API pelo ID")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        apiService.delete(id);
    }

    @Operation(summary = "Executa o monitoramento manual de todas as APIs cadastradas")
    @GetMapping("/monitor-all")
    public String monitorarManual() {
        monitoringService.monitorAllApis();
        return "Monitoramento manual de APIs executado com sucesso.";
    }
}
