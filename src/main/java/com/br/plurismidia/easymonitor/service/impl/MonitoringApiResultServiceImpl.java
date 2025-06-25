package com.br.plurismidia.easymonitor.service.impl;

import com.br.plurismidia.easymonitor.bean.entity.MonitoringResult;
import com.br.plurismidia.easymonitor.repository.MonitoringResultRepository;
import com.br.plurismidia.easymonitor.service.MonitoringApiResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonitoringApiResultServiceImpl implements MonitoringApiResultService {

    private final MonitoringResultRepository repository;

    /**
     * Retorna todos os resultados de monitoramento armazenados.
     *
     * @return lista de MonitoringResult
     */
    @Override
    public List<MonitoringResult> findAll() {
        return repository.findAll();
    }

    /**
     * Remove todos os resultados de monitoramento armazenados no banco.
     */
    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
