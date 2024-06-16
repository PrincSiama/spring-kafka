package dev.sosnovsky.specification;

import dev.sosnovsky.model.Metric;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class MetricSpecification {

    public static Specification<Metric> findByMetricGroup(String metricGroup) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get("metricGroup")), "%" + metricGroup.toLowerCase() + "%"));
    }

    public static Specification<Metric> findFromDate(LocalDateTime from) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("createTime"), from));
    }

    public static Specification<Metric> findToDate(LocalDateTime to) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("createTime"), to));
    }
}
