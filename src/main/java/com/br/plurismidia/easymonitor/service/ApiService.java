package com.br.plurismidia.easymonitor.service;

import com.br.plurismidia.easymonitor.bean.entity.Api;

import java.util.List;

public interface ApiService {

    /**
     * Retorna todas as APIs cadastradas.
     * @return lista de APIs
     */
    List<Api> findAll();

    /**
     * Salva uma nova API.
     * @param api objeto Api a ser salvo
     * @return Api salva
     */
    Api save(Api api);

    /**
     * Atualiza uma API existente pelo id.
     * @param id identificador da API
     * @param newApi objeto Api com novos dados
     * @return Api atualizada ou null se não encontrada
     */
    Api update(Long id, Api newApi);

    /**
     * Remove uma API pelo id.
     * @param id identificador da API a ser removida
     */
    void delete(Long id);
}
