package br.com.gestaofacil.apiHexagonal.application.ports.out;

import br.com.gestaofacil.apiHexagonal.application.core.domain.Client;


public interface UpdateClientOutputPort {

    void updateClient(Client client);

}
