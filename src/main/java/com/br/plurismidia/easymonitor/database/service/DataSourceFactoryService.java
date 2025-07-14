package com.br.plurismidia.easymonitor.database.service;

import com.br.plurismidia.easymonitor.database.entity.DatabaseConfig;
import com.br.plurismidia.easymonitor.database.repository.DatabaseConfigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class DataSourceFactoryService {

    private final DatabaseConfigRepository configRepository;

    private final Map<String, JdbcTemplate> jdbcTemplateCache = new ConcurrentHashMap<>();

    public JdbcTemplate getJdbcTemplate(String nomeConexao) {
        return jdbcTemplateCache.computeIfAbsent(nomeConexao, key -> {
            DatabaseConfig config = configRepository.findByNome(key)
                    .orElseThrow(() -> new IllegalArgumentException("Configuração não encontrada para: " + key));

            try {
                HikariConfig hikariConfig = new HikariConfig();
                hikariConfig.setJdbcUrl(config.getUrl());
                hikariConfig.setUsername(config.getUsername());
                hikariConfig.setPassword(config.getPassword());
                hikariConfig.setDriverClassName(config.getDriverClassName());
                hikariConfig.setMaximumPoolSize(10);
                hikariConfig.setPoolName("Hikari-" + key);

                DataSource dataSource = new HikariDataSource(hikariConfig);
                return new JdbcTemplate(dataSource);
            } catch (Exception e) {
                throw new IllegalStateException("Falha ao configurar DataSource para: " + key, e);
            }
        });
    }
}
