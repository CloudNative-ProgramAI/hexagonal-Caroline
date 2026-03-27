package br.com.gestaofacil.apiHexagonal.application.ports.out;

import br.com.gestaofacil.apiHexagonal.application.core.domain.Client;

import java.util.Optional;

public interface FindClientByIdOutputPort {

    Optional<Client> findClientById(Long id);
}
