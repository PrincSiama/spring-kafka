package dev.sosnovsky.repository;

import dev.sosnovsky.model.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MetricRepository extends JpaRepository<Metric, Integer> {

    Optional<Metric> findFirstByOrderByCreateTimeDesc();

    int countBy();

    List<Metric> findAllByIsExceptionTrue();

    @Query(value = "TRUNCATE metrics RESTART IDENTITY", nativeQuery = true)
    void clearTable();
}
