package dev.sosnovsky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MetricsConsumerApplication
{
    public static void main(String[] args) {
        SpringApplication.run(MetricsConsumerApplication.class, args);
    }
}
