package dev.sosnovsky.repository;

import dev.sosnovsky.model.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MetricRepository extends JpaRepository<Metric, Integer>, JpaSpecificationExecutor<Metric> {

    Optional<Metric> findFirstByOrderByCreateTimeDesc();

    int countBy();

    @Query(value = "TRUNCATE metrics RESTART IDENTITY", nativeQuery = true)
    void clearTable();
}
