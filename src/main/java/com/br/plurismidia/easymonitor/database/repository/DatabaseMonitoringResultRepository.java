package com.br.plurismidia.easymonitor.database.repository;

import com.br.plurismidia.easymonitor.database.entity.DatabaseMonitoringResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseMonitoringResultRepository extends JpaRepository<DatabaseMonitoringResult, Long> {
}
