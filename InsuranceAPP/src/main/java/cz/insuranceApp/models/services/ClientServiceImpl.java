package cz.insuranceApp.models.services;

import cz.insuranceApp.data.entities.ClientEntity;
import cz.insuranceApp.data.repositories.ClientRepository;
import cz.insuranceApp.models.dto.ClientDTO;
import cz.insuranceApp.models.dto.mappers.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;
@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientMapper clientMapper;
    @Override
    public void create(ClientDTO clientDTO) {
        ClientEntity newClient = clientMapper.toEntity(clientDTO);
        clientRepository.save(newClient);
    }

    @Override
    public List<ClientDTO> getAll() {
        return StreamSupport.stream(clientRepository.findAll().spliterator(), false)
                .map(i -> clientMapper.toDTO(i))
                .toList();
    }

    @Override
    public ClientDTO getById(long clientId) {
        return null;
    }

    @Override
    public void edit(ClientDTO clientDTO) {

    }

    @Override
    public void remove(long clientId) {

    }
}
