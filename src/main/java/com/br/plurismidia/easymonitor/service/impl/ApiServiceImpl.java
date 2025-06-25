package com.br.plurismidia.easymonitor.service.impl;

import com.br.plurismidia.easymonitor.bean.entity.Api;
import com.br.plurismidia.easymonitor.repository.ApiRepository;
import com.br.plurismidia.easymonitor.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApiServiceImpl implements ApiService {

    private final ApiRepository repository;

    @Override
    public List<Api> findAll() {
        return repository.findAll();
    }

    @Override
    public Api save(Api api) {
        return repository.save(api);
    }

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

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
