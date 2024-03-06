package com.banana.bananamint.domain;


import javax.persistence.*;
import javax.validation.constraints.Min;

import com.banana.bananamint.exception.CustomerException;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Schema(name = "customer", description = "Modelo usuario")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    @Schema(name = "ID", example = "1", required = false)
    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private String dni;

    public boolean isValid() throws CustomerException {
        // Para que el usuario sea valido:
        // email válido
        // mayor de 18 años
        // dni: 8_Numeros + 1_Letra
        // Si no es válido, debe lanzar exception

        return false;
    }

}
