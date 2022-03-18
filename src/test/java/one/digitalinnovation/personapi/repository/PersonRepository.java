package one.digitalinnovation.personapi.repository;

import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.service.Optinal;
import org.hibernate.mapping.List;

public interface PersonRepository extends JpaRespository< Person, Long>{
    Person save(Person personToSave);

    List findAll();

    Optinal<person> findById(Long id);
}
