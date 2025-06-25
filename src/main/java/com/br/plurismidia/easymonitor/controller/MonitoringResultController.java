package com.br.plurismidia.easymonitor.controller;

import com.br.plurismidia.easymonitor.bean.entity.MonitoringResult;
import com.br.plurismidia.easymonitor.service.MonitoringApiResultService;
import com.br.plurismidia.easymonitor.service.MonitoringApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitor/monitoring")
@RequiredArgsConstructor
@Tag(name = "API Monitoring", description = "Operações de execução e consulta de monitoramento de APIs")
public class MonitoringResultController {

    private final MonitoringApiService monitoringApiService;
    private final MonitoringApiResultService monitoringApiResultService;

    @Operation(summary = "Executa o monitoramento manual de todas as APIs cadastradas")
    @GetMapping("/execute")
    public String executarManual() {
        monitoringApiService.monitorAllApis();
        return "Monitoramento manual executado com sucesso.";
    }

    @Operation(summary = "Retorna todos os resultados de monitoramento")
    @GetMapping("/result")
    public List<MonitoringResult> findResult() {
        return monitoringApiResultService.findAll();
    }

    @Operation(summary = "Remove todos os resultados de monitoramento")
    @DeleteMapping("/result")
    public String deletarTodos() {
        monitoringApiResultService.deleteAll();
        return "Todos os resultados foram deletados.";
    }
}
