package com.br.plurismidia.easymonitor.controller;

import com.br.plurismidia.easymonitor.entity.Api;
import com.br.plurismidia.easymonitor.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitor/api")
@RequiredArgsConstructor
public class ApiController {

    private final ApiService service;

    @GetMapping
    public List<Api> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Api save(@RequestBody Api api) {
        return service.save(api);
    }

    @PutMapping("/{id}")
    public Api update(@PathVariable Long id, @RequestBody Api novaApi) {
        return service.update(id, novaApi);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}