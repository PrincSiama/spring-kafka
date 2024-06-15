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

    private String name;

    private String description;

    @Column(name = "is_exception")
    private Boolean isException;

    @Column(name = "create_time")
    private LocalDateTime createTime = LocalDateTime.now();
}