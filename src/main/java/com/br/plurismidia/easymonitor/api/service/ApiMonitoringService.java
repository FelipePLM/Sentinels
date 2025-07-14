package com.br.plurismidia.easymonitor.api.service;

import com.br.plurismidia.easymonitor.api.entity.MonitoredApi;

import java.util.List;

public interface ApiMonitoringService {
    List<MonitoredApi> findAll();
    MonitoredApi save(MonitoredApi api);
    MonitoredApi update(Long id, MonitoredApi updatedApi);
    void monitorAllApis();
    void delete(Long id);
}
