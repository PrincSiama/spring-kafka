package dev.sosnovsky.consumer;

import dev.sosnovsky.dto.MetricDto;
import dev.sosnovsky.service.MetricService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final MetricService metricService;

    @KafkaListener(topics = "${kafka.metric.topic.name}", groupId = "metrics")
    public void saveMetricFromTopic(MetricDto metricDto) {
        metricService.saveMetric(metricDto);
    }
}
