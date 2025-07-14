package com.br.plurismidia.easymonitor.api.repository;

import com.br.plurismidia.easymonitor.api.entity.MonitoredApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoredApiRepository extends JpaRepository<MonitoredApi, Long> {
}
