package com.br.plurismidia.easymonitor.service;

import com.br.plurismidia.easymonitor.entity.MonitoringResult;
import com.br.plurismidia.easymonitor.repository.MonitoringResultRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@AllArgsConstructor
public class MonitoringApiResultService {

    private final MonitoringResultRepository repository;

    public List<MonitoringResult> findAll() {
        return repository.findAll();
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
