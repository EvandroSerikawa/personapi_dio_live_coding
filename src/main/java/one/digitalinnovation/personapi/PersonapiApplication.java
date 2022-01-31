package one.digitalinnovation.personapi;

import one.digitalinnovation.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;//
import org.springframework.web.bind.annotation.RequestMapping;//
import org.springframework.web.bind.annotation.RestController;//

import org.springframework.boot.SpringApplication;//
import org.springframework.boot.autoconfigure.SpringBootApplication;//

import java.security.PublicKey;


@SpringBootApplication
public class PersonapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonapiApplication.class, args);
	}


@RestController   						// Controlador acessado atraves de uma API REST
@RequestMapping("/api/v1/people") 		// Caminho de acesso principal da API , api / versionamento / classe que gerencia pessoa
public class PersonController{  	    // ponto de entrada do projeto

		@GetMapping      				// Mapeamento de uma operação HTTP do tipo GET
		public String getBook(){
			return "API Test";
		}
}




}
