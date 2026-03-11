package br.com.gestaofacil.apiHexagonal.adapters.out;

import br.com.gestaofacil.apiHexagonal.adapters.out.repository.ClientRepository;
import br.com.gestaofacil.apiHexagonal.adapters.out.repository.entity.ClientEntity;
import br.com.gestaofacil.apiHexagonal.adapters.out.repository.mapper.ClientEntityMapper;
import br.com.gestaofacil.apiHexagonal.application.core.domain.Client;
import br.com.gestaofacil.apiHexagonal.application.ports.out.InsertClientOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertClientAdapter implements InsertClientOutputPort {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientEntityMapper clientEntityMapper;

    @Override
    public void insert(Client client) {
        ClientEntity clientEntity = clientEntityMapper.toClientEntity(client);
        clientRepository.save(clientEntity);
    }
}
