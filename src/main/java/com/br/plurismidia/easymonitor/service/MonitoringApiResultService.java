package com.br.plurismidia.easymonitor.service;

import com.br.plurismidia.easymonitor.bean.entity.MonitoringResult;

import java.util.List;

public interface MonitoringApiResultService {
    List<MonitoringResult> findAll();
    void deleteAll();
}
