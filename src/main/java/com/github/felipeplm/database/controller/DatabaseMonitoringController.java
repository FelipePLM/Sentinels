package com.github.felipeplm.database.controller;

import com.github.felipeplm.database.service.DatabaseMonitoringService;
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
