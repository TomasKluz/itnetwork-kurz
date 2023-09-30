package cz.insuranceApp.models.services;

import cz.insuranceApp.data.entities.ClientEntity;
import cz.insuranceApp.data.repositories.ClientRepository;
import cz.insuranceApp.models.dto.ClientDTO;
import cz.insuranceApp.models.dto.mappers.ClientMapper;
import cz.insuranceApp.models.exceptions.ClientNotFoundException;
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
        ClientEntity fetchedClient = getClientOrThrow(clientId);
        return clientMapper.toDTO(fetchedClient);
    }

    @Override
    public void edit(ClientDTO client) {
        ClientEntity fetchedClient = getClientOrThrow(client.getClientId());
        clientMapper.updateClientEntity(client,fetchedClient);
        clientRepository.save(fetchedClient);

    }

    @Override
    public void remove(long clientId) {

    }
    private ClientEntity getClientOrThrow(long clientId){
        return clientRepository.findById(clientId)
                .orElseThrow(ClientNotFoundException::new);
    }
}
