package com.github.felipeplm.api.repository;

import com.github.felipeplm.api.entity.MonitoredApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoredApiRepository extends JpaRepository<MonitoredApi, Long> {
}
