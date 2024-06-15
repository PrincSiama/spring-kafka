package dev.sosnovsky.controller;

import dev.sosnovsky.producer.KafkaProducer;
import dev.sosnovsky.dto.MetricDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProducerController {

    private final KafkaProducer kafkaProducer;

    @PostMapping("/metrics")
    @Operation(summary = "Сохранение сообщения в топик")
    public String sendMessage(@RequestBody MetricDto metricDto) {
        kafkaProducer.sendMessage(metricDto);
        return "The metrics were successfully sent";
    }
}
