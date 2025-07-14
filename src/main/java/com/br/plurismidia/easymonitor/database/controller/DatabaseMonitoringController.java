package com.br.plurismidia.easymonitor.database.controller;

import com.br.plurismidia.easymonitor.database.service.DatabaseMonitoringService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/monitor/database/run")
@RequiredArgsConstructor
public class DatabaseMonitoringController {

    private final DatabaseMonitoringService monitoringService;

    @GetMapping("/execute")
    public String runMonitoring() {
        monitoringService.runMonitoring();
        return "Monitoramento de banco executado com sucesso.";
    }
}
