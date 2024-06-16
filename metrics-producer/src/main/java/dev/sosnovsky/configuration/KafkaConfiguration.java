package dev.sosnovsky.configuration;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class KafkaConfiguration {

    @Value("${kafka.metric.topic.name}")
    private String topicName;

    @Bean
    public NewTopic createMetricsTopic() {
        return new NewTopic(topicName, 1, (short) 1);
    }
}
