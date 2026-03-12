package br.com.gestaofacil.apiHexagonal.adapters.out;

import br.com.gestaofacil.apiHexagonal.adapters.out.repository.ClientRepository;
import br.com.gestaofacil.apiHexagonal.adapters.out.repository.mapper.ClientEntityMapper;
import br.com.gestaofacil.apiHexagonal.application.core.domain.Client;
import br.com.gestaofacil.apiHexagonal.application.ports.out.FindAllClientsOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllClientsAdapter implements FindAllClientsOutputPort {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientEntityMapper clientEntityMapper;


    @Override
    public List<Client> findAllClients() {
        return clientRepository.findAll().stream()
                .map(clientEntityMapper ::toClient)
                .toList();
    }
}
