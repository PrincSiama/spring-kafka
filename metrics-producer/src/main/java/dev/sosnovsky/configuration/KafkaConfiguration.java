package dev.sosnovsky.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfiguration {

    @Bean
    public NewTopic createMetricsTopic() {
        return new NewTopic("metrics-topic", 1, (short) 1);
    }
}
