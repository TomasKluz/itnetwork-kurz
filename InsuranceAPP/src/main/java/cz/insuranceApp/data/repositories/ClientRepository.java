package cz.insuranceApp.data.repositories;

import cz.insuranceApp.data.entities.ClientEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientEntity, Long> {
}
