package cz.insuranceApp.data.repositories;

import cz.insuranceApp.data.entities.ContractEntity;
import org.springframework.data.repository.CrudRepository;

public interface ContractRepository extends CrudRepository<ContractEntity, Long> {
}
