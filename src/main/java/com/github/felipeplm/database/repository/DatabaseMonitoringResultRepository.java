package com.github.felipeplm.database.repository;

import com.github.felipeplm.database.entity.DatabaseMonitoringResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseMonitoringResultRepository extends JpaRepository<DatabaseMonitoringResult, Long> {
}
