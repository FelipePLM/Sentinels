package com.br.plurismidia.easymonitor.database.repository;

import com.br.plurismidia.easymonitor.database.entity.DatabaseMonitoringQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseMonitoringQueryRepository extends JpaRepository<DatabaseMonitoringQuery, Long> {
}
