package cz.insuranceApp.models.services;

import cz.insuranceApp.models.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    void create(ClientDTO clientDTO);
    List<ClientDTO> getAll();
    ClientDTO getById(long clientId);
    void edit(ClientDTO client);
    void remove(long clientId);
}
