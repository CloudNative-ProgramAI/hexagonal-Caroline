package br.com.gestaofacil.apiHexagonal.application.ports.in;

import br.com.gestaofacil.apiHexagonal.application.core.domain.Client;

import java.util.List;

public interface FindAllClientsInputPort {

    List<Client> findAllClients();
}
