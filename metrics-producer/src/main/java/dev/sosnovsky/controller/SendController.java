package dev.sosnovsky.controller;

import dev.sosnovsky.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SendController {

    private final KafkaProducer kafkaProducer;

    @PostMapping("/send")
    public String sendMessage(@RequestBody String message) {
        kafkaProducer.sendMessage(message);
        log.info("Сообщение {} из SendController отправлено в брокер", message);
        return "The metrics were successfully sent";
    }
}
