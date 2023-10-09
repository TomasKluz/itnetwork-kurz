package cz.insuranceApp.models.services;

import cz.insuranceApp.data.entities.ClientEntity;
import cz.insuranceApp.models.dto.ClientDTO;
import cz.insuranceApp.models.dto.ContractDTO;

import java.util.List;

public interface ContractService {
    void create (ClientEntity clientEntity, ContractDTO contractDTO);
    List<ContractDTO> getAll();
    ContractDTO getById(long contractId);
    void edite(ContractDTO contractDTO);
    void remove(long contractId);
}

