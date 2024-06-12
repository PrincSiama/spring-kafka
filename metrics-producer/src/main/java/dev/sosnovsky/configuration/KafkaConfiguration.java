package dev.sosnovsky.configuration;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class KafkaConfiguration {

    @Bean
    public NewTopic createMetricsTopic() {
        log.info("Создан топик metrics-topic");
        return new NewTopic("metrics-topic", 1, (short) 1);
    }
}
