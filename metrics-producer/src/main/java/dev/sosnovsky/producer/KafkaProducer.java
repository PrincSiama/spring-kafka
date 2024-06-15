package dev.sosnovsky.producer;

import dev.sosnovsky.dto.MetricDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(MetricDto metricDto) {
        kafkaTemplate.send("metrics-topic", metricDto);
    }
}
