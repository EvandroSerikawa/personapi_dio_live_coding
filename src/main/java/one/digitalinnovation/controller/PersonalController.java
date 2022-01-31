package one.digitalinnovation.controller;

// ponto de entrada , não inserir regras de negocio nessa classe
// Utilizar a classe service


import one.digitalinnovation.dto.request.PersonDTO;
import one.digitalinnovation.dto.response.MessageResponseDTO;
import one.digitalinnovation.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping ("/api/v1/people")
public class PersonalController {


    private PersonService personService;

    @Autowired
    public PersonalController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson( @RequestBody @Valid PersonDTO personDTO) {  // Requisição ( Informação JSON )
            return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> ListAll(){
       return personService.listAll();
    }


}

