package com.br.plurismidia.easymonitor.config;

import com.br.plurismidia.easymonitor.service.MonitoringApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Scheduler {

    private final MonitoringApiService monitoringService;

    @Scheduled(fixedDelay = 300000)
    public void executeMonitoring() {
        System.out.println("Executando monitoring...");
        monitoringService.monitorAllApis();
    }
}
