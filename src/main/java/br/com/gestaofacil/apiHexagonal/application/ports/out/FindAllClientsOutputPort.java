package br.com.gestaofacil.apiHexagonal.application.ports.out;

import br.com.gestaofacil.apiHexagonal.application.core.domain.Client;

import java.util.List;

public interface FindAllClientsOutputPort {

    List<Client> findAllClients();
}
