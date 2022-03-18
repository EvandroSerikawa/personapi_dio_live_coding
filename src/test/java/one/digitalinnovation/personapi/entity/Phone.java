package one.digitalinnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.PhoneType;

import javax.persistence.*;

@Entity  // Entidade
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Phone {

    @Id // PK  - @Entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AutoIncrement

    private long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false) // Campo NOT NULL DB - CAMPOS OBRIGATÓRIOS

    private PhoneType type;
    @Column(nullable = false) // Campo NOT NULL DB - CAMPOS OBRIGATÓRIOS

    private String number;


}
