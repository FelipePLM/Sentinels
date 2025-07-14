package com.br.plurismidia.easymonitor.common.config;

import com.br.plurismidia.easymonitor.api.service.ApiMonitoringService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SchedulerConfig {

    private final ApiMonitoringService apiMonitoringService;

    @Scheduled(fixedDelay = 1200000) // 20 minutos
    public void scheduledApiMonitoring() {
        apiMonitoringService.monitorAllApis();
    }
}
