package com.github.felipeplm.database.repository;

import com.github.felipeplm.database.entity.DatabaseMonitoringQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseMonitoringQueryRepository extends JpaRepository<DatabaseMonitoringQuery, Long> {
}
