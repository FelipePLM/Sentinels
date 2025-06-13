package com.br.plurismidia.easymonitor.controller;

import com.br.plurismidia.easymonitor.entity.MonitoringResult;
import com.br.plurismidia.easymonitor.service.MonitoringApiResultService;
import com.br.plurismidia.easymonitor.service.MonitoringApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitor/monitoring")
@RequiredArgsConstructor
public class MonitoringResultController {

    private final MonitoringApiService monitoringApiService;
    private final MonitoringApiResultService monitoringApiResultService;

    @GetMapping("/execute")
    public String executarManual() {
        monitoringApiService.monitorAllApis();
        return "Monitoramento manual executado com sucesso.";
    }

    @GetMapping("/result")
    public List<MonitoringResult> findResult() {
        return monitoringApiResultService.findAll();
    }

    @DeleteMapping("/result")
    public String deletarTodos() {
        monitoringApiResultService.deleteAll();
        return "Todos os resultados foram deletados.";
    }
}