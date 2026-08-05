package com.github.felipeplm.database.controller;

import com.github.felipeplm.database.entity.DatabaseMonitoringQuery;
import com.github.felipeplm.database.repository.DatabaseMonitoringQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitor/database/query")
@RequiredArgsConstructor
public class DatabaseMonitoringQueryController {

    private final DatabaseMonitoringQueryRepository repository;

    @GetMapping
    public List<DatabaseMonitoringQuery> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public DatabaseMonitoringQuery save(@RequestBody DatabaseMonitoringQuery query) {
        return repository.save(query);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
