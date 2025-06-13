package com.br.plurismidia.easymonitor.service;

import com.br.plurismidia.easymonitor.entity.Api;
import com.br.plurismidia.easymonitor.repository.ApiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApiService {

    private final ApiRepository repository;

    public List<Api> findAll() {
        return repository.findAll();
    }

    public Api save(Api api) {
        return repository.save(api);
    }

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

    public void delete(Long id) {
        repository.deleteById(id);
    }
}