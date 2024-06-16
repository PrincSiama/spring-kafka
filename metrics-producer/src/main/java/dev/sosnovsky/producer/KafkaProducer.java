package dev.sosnovsky.producer;

import dev.sosnovsky.dto.MetricDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    @Value("${kafka.metric.topic.name}")
    private String topicName;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(MetricDto metricDto) {
        kafkaTemplate.send(topicName, metricDto);
    }
}
