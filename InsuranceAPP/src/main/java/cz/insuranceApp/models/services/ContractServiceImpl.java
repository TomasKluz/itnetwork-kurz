package cz.insuranceApp.models.services;

import cz.insuranceApp.data.entities.ClientEntity;
import cz.insuranceApp.data.entities.ContractEntity;
import cz.insuranceApp.data.repositories.ContractRepository;
import cz.insuranceApp.models.dto.ContractDTO;
import cz.insuranceApp.models.dto.mappers.ContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;
    @Autowired
    ContractMapper contractMapper;
    @Override
    public void create(ClientEntity clientEntity, ContractDTO contractDTO) {
        ContractEntity newContract = contractMapper.toEntity(contractDTO);
        newContract.setClient(clientEntity);
        contractRepository.save(newContract);
    }

    @Override
    public List<ContractDTO> getAll() {
        return null;
    }

    @Override
    public ContractDTO getById(long contractId) {
        return null;
    }

    @Override
    public void edite(ContractDTO contractDTO) {

    }

    @Override
    public void remove(long contractId) {

    }
}
