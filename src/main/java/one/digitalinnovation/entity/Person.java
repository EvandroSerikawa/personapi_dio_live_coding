package one.digitalinnovation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.enums.PhoneType;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(nullable = false) // NOT NULL

    private String firstName;

    @Column(nullable = false) // NOT NULL
    private String lastName;

    @Column(nullable = false) // NOT NULL
    private String cpf;

    @Column(nullable = false, unique = true) // NOT NULL -  UNIQUE DB
    private PhoneType type;

    private localDate birthDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE , CascadeType.REMOVE})
    // lazy - Performance ( junção de dados - JOIN cascade )
    private List<Phone> phone;  // CARDINALIDADE

}
