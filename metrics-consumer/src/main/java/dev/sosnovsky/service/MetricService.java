package dev.sosnovsky.service;

import dev.sosnovsky.dto.MetricDto;
import dev.sosnovsky.model.Metric;

import java.util.List;

public interface MetricService {

    Metric saveMetric(MetricDto metricDto);

    List<Metric> getAllMetrics();

    Metric getMetricById(int id);

    Metric getLastMetric();

    String getCountOfMetrics();

    List<Metric> getMetricsWithExceptions();

    void clearMetrics();
}
