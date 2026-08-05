package com.github.felipeplm.database.repository;

import com.github.felipeplm.database.entity.DatabaseConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DatabaseConfigRepository extends JpaRepository<DatabaseConfig, Long> {
    Optional<DatabaseConfig> findByNome(String nome);
}
