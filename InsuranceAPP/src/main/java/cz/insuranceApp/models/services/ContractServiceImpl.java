package cz.insuranceApp.models.services;

import cz.insuranceApp.data.entities.ClientEntity;
import cz.insuranceApp.data.entities.ContractEntity;
import cz.insuranceApp.data.repositories.ContractRepository;
import cz.insuranceApp.models.dto.ContractDTO;
import cz.insuranceApp.models.dto.mappers.ContractMapper;
import cz.insuranceApp.models.exceptions.ClientNotFoundException;
import cz.insuranceApp.models.exceptions.ContractNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

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
        return StreamSupport.stream(contractRepository.findAll().spliterator(),false)
                .map(i -> contractMapper.toDTO(i))
                .toList();
    }

    @Override
    public ContractDTO getById(long contractId) {
        ContractEntity fetchedContract = getContractOrThrow(contractId);
        return contractMapper.toDTO(fetchedContract);
    }

    @Override
    public void edite(ContractDTO contractDTO) {
        ContractEntity contractEntity = getContractOrThrow(contractDTO.getContractId());
        contractDTO.setClient(contractEntity.getClient());
        contractDTO.setInsuranceName(contractEntity.getInsuranceName());
        contractMapper.updateContractEntity(contractDTO,contractEntity);
        contractRepository.save(contractEntity);

    }

    @Override
    public void remove(long contractId) {
        ContractEntity contract = getContractOrThrow(contractId);
        contractRepository.delete(contract);

    }
    private ContractEntity getContractOrThrow(long contractId){
        return contractRepository.findById(contractId)
                .orElseThrow(ContractNotFoundException::new);
    }
}
