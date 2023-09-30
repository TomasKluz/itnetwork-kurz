package cz.insuranceApp.models.dto.mappers;

import cz.insuranceApp.data.entities.ClientEntity;
import cz.insuranceApp.models.dto.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientEntity toEntity(ClientDTO source);
    ClientDTO toDTO(ClientEntity source);

    void updateClientDTO(ClientDTO source, @MappingTarget ClientDTO target);
    void updateClientEntity(ClientDTO source, @MappingTarget ClientEntity target);

}
