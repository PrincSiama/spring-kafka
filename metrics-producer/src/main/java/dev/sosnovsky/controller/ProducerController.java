package dev.sosnovsky.controller;

import dev.sosnovsky.MetricDto;
import dev.sosnovsky.dto.SuccessResponseDto;
import dev.sosnovsky.producer.KafkaProducer;
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
    public SuccessResponseDto sendMessage(@RequestBody MetricDto metricDto) {
        kafkaProducer.sendMessage(metricDto);
        return new SuccessResponseDto("Метрика была успешно отправлена");
    }
}
