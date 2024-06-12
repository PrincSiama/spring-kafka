package dev.sosnovsky;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "metrics-topic", groupId = "metrics")
    public void listener(String message) {
        log.info("listener принял сообщение {}", message);
    }
}
