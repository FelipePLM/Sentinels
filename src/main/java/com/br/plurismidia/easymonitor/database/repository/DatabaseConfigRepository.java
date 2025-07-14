package com.br.plurismidia.easymonitor.database.repository;

import com.br.plurismidia.easymonitor.database.entity.DatabaseConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DatabaseConfigRepository extends JpaRepository<DatabaseConfig, Long> {
    Optional<DatabaseConfig> findByNome(String nome);
}
