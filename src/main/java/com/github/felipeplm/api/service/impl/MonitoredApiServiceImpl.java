package com.github.felipeplm.api.service.impl;

import com.github.felipeplm.api.entity.MonitoredApi;
import com.github.felipeplm.api.repository.MonitoredApiRepository;
import com.github.felipeplm.api.service.MonitoredApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MonitoredApiServiceImpl implements MonitoredApiService {

    private final MonitoredApiRepository repository;

    @Override
    public List<MonitoredApi> findAll() {
        return repository.findAll();
    }

    @Override
    public MonitoredApi save(MonitoredApi api) {
        return repository.save(api);
    }

    @Override
    public MonitoredApi update(Long id, MonitoredApi updatedApi) {
        Optional<MonitoredApi> exist = repository.findById(id);
        if (exist.isPresent()) {
            MonitoredApi api = exist.get();
            api.setName(updatedApi.getName());
            api.setUrl(updatedApi.getUrl());
            return repository.save(api);
        }
        throw new RuntimeException("API não encontrada com id: " + id);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
