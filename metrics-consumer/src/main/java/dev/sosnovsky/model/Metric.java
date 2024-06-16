package dev.sosnovsky.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "metrics")
public class Metric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "metric_group")
    private String metricGroup;

    private Double value;

    @Column(name = "create_time")
    private LocalDateTime createTime = LocalDateTime.now();
}