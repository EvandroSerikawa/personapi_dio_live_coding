package one.digitalinnovation.repository;

import one.digitalinnovation.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRespository< Person, Long>{
}
