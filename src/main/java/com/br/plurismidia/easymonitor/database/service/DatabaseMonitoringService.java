package com.br.plurismidia.easymonitor.database.service;

import com.br.plurismidia.easymonitor.database.entity.DatabaseMonitoringQuery;
import com.br.plurismidia.easymonitor.database.entity.DatabaseMonitoringResult;
import com.br.plurismidia.easymonitor.database.repository.DatabaseMonitoringQueryRepository;
import com.br.plurismidia.easymonitor.database.repository.DatabaseMonitoringResultRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DatabaseMonitoringService {

    private final DatabaseMonitoringQueryRepository queryRepository;
    private final DatabaseMonitoringResultRepository resultRepository;
    private final DataSourceFactoryService dataSourceFactoryService;

    public void runMonitoring() {
        List<DatabaseMonitoringQuery> queries = queryRepository.findAll();

        for (DatabaseMonitoringQuery query : queries) {
            try {
                JdbcTemplate jdbcTemplate = dataSourceFactoryService.getJdbcTemplate(query.getJdbcTemplateName());
                List<Map<String, Object>> rows = jdbcTemplate.queryForList(query.getSqlQuery());

                String resultado = rows.stream()
                        .map(Map::toString)
                        .collect(Collectors.joining("\n"));

                DatabaseMonitoringResult result = DatabaseMonitoringResult.builder()
                        .nameApi(query.getDescription())
                        .status(resultado.length() > 1000 ? resultado.substring(0, 1000) + "..." : resultado)
                        .dateTime(LocalDateTime.now())
                        .build();

                resultRepository.save(result);
            } catch (Exception e) {
                log.error("Erro ao executar query '{}': {}", query.getDescription(), e.getMessage(), e);
                resultRepository.save(DatabaseMonitoringResult.builder()
                        .nameApi(query.getDescription())
                        .status("Erro: " + e.getMessage())
                        .dateTime(LocalDateTime.now())
                        .build());
            }
        }
    }
}
