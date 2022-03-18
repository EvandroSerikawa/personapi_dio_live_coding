package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.mapper.PersonMapper;
import one.digitalinnovation.personapi.repository.PersonRepository;
import one.digitalinnovation.personapi.PerspnApiNotFoundException.PersonNotFoundException;
import one.digitalinnovation.personapi.repository.person;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;

import java.util.stream.Collectors;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

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


        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getID())
                .build();
    }

    public List<PersonDTO> listAll() throws PersonNotFoundException {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper :: toDTO)
                .collect(Collectors.toList());

        public PersonDTO findById(Long id) throws PersonNotFoundException{
            Optinal<person> optinalPerson =  personRepository.findById(id);
            if( optinalPerson isEmpty()){
                throw new PersonNotFoundException(id);
            }
            return personMapper.toDTO(optinalPerson.get());

        }

    }

    public PersonDTO findById(Long id) {

    }
}
