package one.digitalinnovation.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum PhoneType {

    NOME( "Home"),
    MOBILE("Mobile"),
    COMERCIAL("Comercial");

    private final String description;


}