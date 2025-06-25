package com.br.plurismidia.easymonitor.config;

import com.br.plurismidia.easymonitor.service.MonitoringApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Scheduler {

    @Autowired
    private MonitoringApiService monitoringService;

    @Scheduled(fixedDelay = 3000000)
    public void executeMonitoring() {
        System.out.println("Executando monitoring...");
        monitoringService.monitorAllApis();
    }
}
