package dev.sosnovsky.service;

import dev.sosnovsky.dto.MetricDto;
import dev.sosnovsky.dto.SuccessResponseDto;
import dev.sosnovsky.model.Metric;

import java.time.LocalDateTime;
import java.util.List;

public interface MetricService {

    Metric saveMetric(MetricDto metricDto);

    Metric getMetricById(int id);

    Metric getLastMetric();

    SuccessResponseDto getCountOfMetrics();

    List<Metric> findAllMetricsByGroupAndCreateDate(String metricGroup, LocalDateTime from, LocalDateTime to);

    void clearMetrics();
}
