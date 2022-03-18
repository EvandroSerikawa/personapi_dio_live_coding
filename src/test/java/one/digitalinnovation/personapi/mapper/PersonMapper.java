package one.digitalinnovation.personapi.mapper;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;
import org.hibernate.mapping.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapper( target  = "birthDate" , source = "birtDate" , dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);  // toMOdel para converter para DB

    List toDTO(Person person);

    Person toModel(PersonDTO personDTO);
}