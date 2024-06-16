package dev.sosnovsky.service;

import dev.sosnovsky.MetricDto;
import dev.sosnovsky.exception.NotFoundException;
import dev.sosnovsky.model.Metric;
import dev.sosnovsky.repository.MetricRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MetricServiceImpl implements MetricService {

    private final MetricRepository metricRepository;
    private final ModelMapper mapper;

    @Override
    public Metric saveMetric(MetricDto metricDto) {
        Metric metric = mapper.map(metricDto, Metric.class);
        return metricRepository.save(metric);
    }

    @Override
    public List<Metric> getAllMetrics() {
        return metricRepository.findAll();
    }

    @Override
    public Metric getMetricById(int id) {
        return metricRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Невозможно получить метрику с id " + id +
                        ". Метрика с таким id не существует"));
    }

    @Override
    public Metric getLastMetric() {
        return metricRepository.findFirstByOrderByCreateTimeDesc().orElseThrow(
                () -> new NotFoundException("Невозможно получить последнюю метрику. " +
                        "В базе данных отсутствуют метрики"));
    }

    @Override
    public String getCountOfMetrics() {
        return "Количество сохранённых в базе метрик: " + metricRepository.countBy();
    }

    @Override
    public List<Metric> getMetricsWithExceptions() {
        return metricRepository.findAllByIsExceptionTrue();
    }

    @Override
    public void clearMetrics() {
        metricRepository.clearTable();
    }
}
