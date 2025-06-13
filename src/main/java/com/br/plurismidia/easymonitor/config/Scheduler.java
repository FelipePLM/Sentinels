package com.br.plurismidia.easymonitor.config;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Scheduler {

    private final MonitoringService monitoringService;

    @Scheduled(fixedDelay = "300000")
    public void executeMonitoring() {
        System.out.println("Executando monitoring...");
        monitoringService.monitoringAllApis();
    }
}
