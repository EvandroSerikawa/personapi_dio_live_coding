package one.digitalinnovation.mapper;

import one.digitalinnovation.dto.request.PersonDTO;
import one.digitalinnovation.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMappers(PersonMapper.class)

    @Mapping(target = "birthDate" , source = "birthDate" , dateFormat = " dd-mm-yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
