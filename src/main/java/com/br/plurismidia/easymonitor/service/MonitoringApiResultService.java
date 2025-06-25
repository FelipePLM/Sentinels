package com.br.plurismidia.easymonitor.service;

import com.br.plurismidia.easymonitor.bean.entity.MonitoringResult;

import java.util.List;

public interface MonitoringApiResultService {

    /**
     * Retorna todos os resultados de monitoramento.
     * @return lista de resultados
     */
    List<MonitoringResult> findAll();

    /**
     * Remove todos os resultados de monitoramento.
     */
    void deleteAll();
}
