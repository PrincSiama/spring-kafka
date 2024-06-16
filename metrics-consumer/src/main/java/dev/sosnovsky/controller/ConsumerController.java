package dev.sosnovsky.controller;

import dev.sosnovsky.dto.SuccessResponseDto;
import dev.sosnovsky.model.Metric;
import dev.sosnovsky.service.MetricService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/metrics")
public class ConsumerController {

    private final MetricService metricService;

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
    public SuccessResponseDto getCountOfMetrics() {
        return metricService.getCountOfMetrics();
    }

    @GetMapping("/statistic")
    @Operation(summary = "Получение списка метрик по заданной группе за определенный период времени. " +
            "При отсутствии параметров получим список всех метрик за всё время")
    public List<Metric> getMetricsByMetricGroup(@RequestParam(value = "group", required = false) String group,
                                                @RequestParam(value = "from", required = false)
                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
                                                @RequestParam(value = "to", required = false)
                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to) {
        return metricService.findAllMetricsByGroupAndCreateDate(group, from, to);
    }

    @PostMapping("/clear")
    @Operation(summary = "Очистка таблицы")
    public void clearMetrics() {
        metricService.clearMetrics();
    }
}