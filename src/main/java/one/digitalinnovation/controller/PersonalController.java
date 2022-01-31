package one.digitalinnovation.controller;

// ponto de entrada , não inserir regras de negocio nessa classe
// Utilizar a classe service


import one.digitalinnovation.dto.response.MessageResponseDTO;
import one.digitalinnovation.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping ("/api/v1/people")
public class PersonalController {

    private PersonRepository personRepository;

    @Autowired  // CONSTRUTOR
    public PersonRepository(PersonRepository personRepository){
        this.personRepository = personRepository;
    }



    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody  Person person) {  // Requisição ( Informação JSON )
        person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getID())
                .build();
    }
}
