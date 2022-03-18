package one.digitalinnovation.personapi.controller;

// ponto de entrada , não inserir regras de negocio nessa classe
// Utilizar a classe service


import one.digitalinnovation.personapi.PerspnApiNotFoundException.PersonNotFoundException;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.service.PersonService;
import org.hibernate.mapping.List;
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
    protected List<PersonDTO> ListAll() throws PersonNotFoundException {
       return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable  Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }




}

