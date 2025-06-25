package com.br.plurismidia.easymonitor.repository;

import com.br.plurismidia.easymonitor.bean.entity.MonitoringResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoringResultRepository extends JpaRepository<MonitoringResult, Long> {
}
