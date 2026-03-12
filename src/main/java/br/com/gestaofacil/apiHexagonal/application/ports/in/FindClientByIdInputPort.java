package br.com.gestaofacil.apiHexagonal.application.ports.in;

import br.com.gestaofacil.apiHexagonal.application.core.domain.Client;

public interface FindClientByIdInputPort {

    Client findClientById(Long id);
}
