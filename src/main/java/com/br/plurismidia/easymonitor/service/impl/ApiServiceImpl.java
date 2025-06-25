package com.br.plurismidia.easymonitor.service.impl;

import com.br.plurismidia.easymonitor.bean.entity.Api;
import com.br.plurismidia.easymonitor.repository.ApiRepository;
import com.br.plurismidia.easymonitor.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementação do serviço para gerenciamento da entidade Api.
 * Realiza operações CRUD utilizando o repositório JpaRepository.
 */
@Service
@RequiredArgsConstructor
public class ApiServiceImpl implements ApiService {

    private final ApiRepository repository;

    /**
     * Retorna todas as APIs cadastradas.
     *
     * @return lista de APIs
     */
    @Override
    public List<Api> findAll() {
        return repository.findAll();
    }

    /**
     * Persiste uma nova API no banco de dados.
     *
     * @param api objeto Api a ser salvo
     * @return a API salva com ID gerado
     */
    @Override
    public Api save(Api api) {
        return repository.save(api);
    }

    /**
     * Atualiza uma API existente pelo seu ID.
     * Se a API existir, atualiza os campos name e url (se forem não nulos).
     *
     * @param id ID da API a ser atualizada
     * @param newApi objeto Api com os novos dados
     * @return a API atualizada ou null se não existir
     */
    @Override
    public Api update(Long id, Api newApi) {
        Optional<Api> exist = repository.findById(id);
        if (exist.isPresent()) {
            Api api = exist.get();
            if (newApi.getName() != null) api.setName(newApi.getName());
            if (newApi.getUrl() != null) api.setUrl(newApi.getUrl());
            return repository.save(api);
        }
        return null;
    }

    /**
     * Remove a API pelo seu ID.
     *
     * @param id ID da API a ser removida
     */
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
