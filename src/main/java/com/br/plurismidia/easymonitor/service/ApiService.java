package com.br.plurismidia.easymonitor.service;

import com.br.plurismidia.easymonitor.bean.entity.Api;

import java.util.List;

public interface ApiService {
    List<Api> findAll();
    Api save(Api api);
    Api update(Long id, Api newApi);
    void delete(Long id);
}
