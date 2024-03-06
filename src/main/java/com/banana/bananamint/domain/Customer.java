package com.banana.bananamint.domain;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.banana.bananamint.exception.CustomerException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.security.PrivilegedAction;
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

    @Size(min = 3, max = 20)
    @Schema(name = "name", example = "UML", required = true)
    private String name;

    @Size(min = 3, max = 50)
    @Schema(name = "email", example = "uml@u.com", required = true)
    private String email;

    @Column(name="birth_date")
    @DateTimeFormat
    @NotNull
    @Schema(name = "birth_date", example = "2004-01-31", required = true)
    private LocalDate birthDate;

    @Size(min = 9, max = 9)
    @Schema(name = "dni", example = "04653011L", required = true)
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
