package com.br.plurismidia.easymonitor.api.service;

import com.br.plurismidia.easymonitor.api.entity.MonitoredApi;

import java.util.List;

public interface MonitoredApiService {
    List<MonitoredApi> findAll();
    MonitoredApi save(MonitoredApi api);
    MonitoredApi update(Long id, MonitoredApi updatedApi);
    void delete(Long id);
}
