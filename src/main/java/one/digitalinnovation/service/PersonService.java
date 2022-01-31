package one.digitalinnovation.service;

import one.digitalinnovation.dto.response.MessageResponseDTO;
import one.digitalinnovation.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public MessageResponseDTO createPerson( Person person) {  // Requisição ( Informação JSON )
        person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getID())
                .build();
    }

}
