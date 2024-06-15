package dev.sosnovsky.controller;

import dev.sosnovsky.model.Metric;
import dev.sosnovsky.service.MetricService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/metrics")
public class ConsumerController {

    private final MetricService metricService;

    @GetMapping
    @Operation(summary = "Получение списка всех метрик из базы")
    public List<Metric> getAllMetrics() {
        return metricService.getAllMetrics();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение метрики по id")
    public Metric getMetricById(@PathVariable @Min(1) int id) {
        return metricService.getMetricById(id);
    }

    @GetMapping("/statistic/last")
    @Operation(summary = "Получение последней записанной в базу метрики")
    public Metric getLastMetric() {
        return metricService.getLastMetric();
    }

    @GetMapping("/statistic/count")
    @Operation(summary = "Получение общего количества метрик в базе данных")
    public String getCountOfMetrics() {
        return metricService.getCountOfMetrics();
    }

    @GetMapping("/statistic/exception")
    @Operation(summary = "Получение списка метрик с ошибками")
    public List<Metric> getMetricsWithExceptions() {
        return metricService.getMetricsWithExceptions();
    }

    @PostMapping("/clear")
    @Operation(summary = "Очистка таблицы")
    public void clearMetrics() {
        metricService.clearMetrics();
    }
}
