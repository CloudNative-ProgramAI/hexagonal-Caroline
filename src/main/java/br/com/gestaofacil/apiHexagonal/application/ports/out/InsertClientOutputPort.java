package br.com.gestaofacil.apiHexagonal.application.ports.out;

import br.com.gestaofacil.apiHexagonal.application.core.domain.Client;

public interface InsertClientOutputPort {

    void insert(Client client);
}
