package com.br.plurismidia.easymonitor.config;

import com.br.plurismidia.easymonitor.service.MonitoringApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Scheduler {

    @Autowired
    private MonitoringApiService monitoringService;

    /**
     * Método agendado para executar o monitoramento a cada 1200000ms (~20 minutos).
     */
    @Scheduled(fixedDelay = 1200000)
    public void executeMonitoring() {
        System.out.println("Executando monitoring...");
        monitoringService.monitorAllApis();
    }
}
