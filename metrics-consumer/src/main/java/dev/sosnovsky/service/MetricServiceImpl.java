package dev.sosnovsky.service;

import dev.sosnovsky.dto.MetricDto;
import dev.sosnovsky.dto.SuccessResponseDto;
import dev.sosnovsky.exception.NotFoundException;
import dev.sosnovsky.model.Metric;
import dev.sosnovsky.repository.MetricRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static dev.sosnovsky.specification.MetricSpecification.*;

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
    public SuccessResponseDto getCountOfMetrics() {
        return new SuccessResponseDto("Количество сохранённых в базе метрик: " + metricRepository.countBy());
    }

    @Override
    public List<Metric> findAllMetricsByGroupAndCreateDate(String metricGroup, LocalDateTime from, LocalDateTime to) {
        Specification<Metric> specification = searchParametersToSpecification(metricGroup, from, to);

        return metricRepository.findAll(specification);
    }

    @Override
    public void clearMetrics() {
        metricRepository.clearTable();
    }

    private Specification<Metric> searchParametersToSpecification(String metricGroup,
                                                                  LocalDateTime from, LocalDateTime to) {
        List<Specification<Metric>> specifications = new ArrayList<>();

        specifications.add(metricGroup == null ? null : findByMetricGroup(metricGroup));
        specifications.add(from == null ? null : findFromDate(from));
        specifications.add(to == null ? null : findToDate(to));

        return specifications.stream().filter(Objects::nonNull).reduce(Specification::and)
                .orElse((root, query, criteriaBuilder) -> criteriaBuilder.conjunction());
    }
}