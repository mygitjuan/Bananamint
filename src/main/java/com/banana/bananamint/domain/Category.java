package com.banana.bananamint.domain;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Schema(name = "category", description = "Modelo categoria")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    @Schema(name = "ID", example = "1", required = false)
    private Integer id;

    @Size(min = 3, max = 20)
    @Schema(name = "name", example = "UML", required = true)
    private String name;

    @Size(min = 3, max = 20)
    @Schema(name = "type", example = "UML", required = true)
    private String type;

    @Size(min = 3, max = 20)
    @Schema(name = "description", example = "UML", required = true)
    private String description;

    @Column(name="create_dat")
    @DateTimeFormat
    @NotNull
    @Schema(name = "createdAt", example = "2024-01-31", required = true)
    private LocalDate createdAt;
}
