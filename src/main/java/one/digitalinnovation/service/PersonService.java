package one.digitalinnovation.service;

import one.digitalinnovation.dto.request.PersonDTO;
import one.digitalinnovation.dto.response.MessageResponseDTO;
import one.digitalinnovation.entity.Person;
import one.digitalinnovation.mapper.PersonMapper;
import one.digitalinnovation.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;


    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public MessageResponseDTO createPerson(PersonDTO personDTO) {  // Requisição ( Informação JSON )
        Person personToSave = personMapper.toModel(personDTO);


        Person savedPerson = personRepository.save(personDTO);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getID())
                .build();
    }

    public List<PersonDTO>listAll(){
        List<Person>allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper :: toDTO)
                .collect(Collectors.toList());

    }

}
