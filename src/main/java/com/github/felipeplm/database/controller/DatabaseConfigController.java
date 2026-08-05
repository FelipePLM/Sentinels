package com.github.felipeplm.database.controller;

import com.github.felipeplm.database.entity.DatabaseConfig;
import com.github.felipeplm.database.repository.DatabaseConfigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitor/database/config")
@RequiredArgsConstructor
public class DatabaseConfigController {

    private final DatabaseConfigRepository repository;

    @GetMapping
    public List<DatabaseConfig> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public DatabaseConfig save(@RequestBody DatabaseConfig config) {
        return repository.save(config);
    }

    @PutMapping("/{id}")
    public DatabaseConfig update(@PathVariable Long id, @RequestBody DatabaseConfig newConfig) {
        return repository.findById(id).map(config -> {
            config.setNome(newConfig.getNome());
            config.setUrl(newConfig.getUrl());
            config.setUsername(newConfig.getUsername());
            config.setPassword(newConfig.getPassword());
            config.setDriverClassName(newConfig.getDriverClassName());
            return repository.save(config);
        }).orElseThrow(() -> new RuntimeException("Configuração não encontrada: " + id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
