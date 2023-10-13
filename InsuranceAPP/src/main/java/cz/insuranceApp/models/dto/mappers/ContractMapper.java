package cz.insuranceApp.models.dto.mappers;

import cz.insuranceApp.data.entities.ClientEntity;
import cz.insuranceApp.data.entities.ContractEntity;
import cz.insuranceApp.models.dto.ClientDTO;
import cz.insuranceApp.models.dto.ContractDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ContractMapper {

    ContractEntity toEntity(ContractDTO source);
    ContractDTO toDTO(ContractEntity source);

    void updateContractDTO(ContractDTO source, @MappingTarget ContractDTO target);
    void updateContractEntity(ContractDTO source, @MappingTarget ContractEntity target);
}
