package br.com.gestaofacil.apiHexagonal.adapters.out;

import br.com.gestaofacil.apiHexagonal.adapters.out.repository.ClientRepository;
import br.com.gestaofacil.apiHexagonal.adapters.out.repository.entity.ClientEntity;
import br.com.gestaofacil.apiHexagonal.adapters.out.repository.mapper.ClientEntityMapper;
import br.com.gestaofacil.apiHexagonal.application.core.domain.Client;
import br.com.gestaofacil.apiHexagonal.application.ports.out.FindClientByIdOutputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.UpdateClientOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("updateClientAdapter")
public class UpdateClientAdapter implements UpdateClientOutputPort, FindClientByIdOutputPort {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientEntityMapper clientEntityMapper;


    @Override
    public Optional<Client> findClientById(Long id) {
        return clientRepository.findById(id)
                .map(clientEntityMapper::toClient);
    }

    @Override
    public void updateClient(Client client) {
        ClientEntity clientEntity = clientRepository.findById(client.getId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado para persistência"));
        clientEntityMapper.updateEntityFromDomain(client, clientEntity);
        clientRepository.save(clientEntity);
    }
}
