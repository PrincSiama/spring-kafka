package dev.sosnovsky;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetricDto {

    private String name;
    private String description;
    private Boolean isException = false;

    public MetricDto(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
