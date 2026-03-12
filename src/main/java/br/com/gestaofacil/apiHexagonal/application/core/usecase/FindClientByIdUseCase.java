package br.com.gestaofacil.apiHexagonal.application.core.usecase;

import br.com.gestaofacil.apiHexagonal.application.core.domain.Client;
import br.com.gestaofacil.apiHexagonal.application.ports.in.FindClientByIdInputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.FindClientByIdOutputPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FindClientByIdUseCase implements FindClientByIdInputPort {

    private final FindClientByIdOutputPort findClientByIdOutputPort;

    public FindClientByIdUseCase(FindClientByIdOutputPort findClientByIdOutputPort){
        this.findClientByIdOutputPort = findClientByIdOutputPort;
    }

    @Override
    public Client findClientById(Long id) {

        return findClientByIdOutputPort.findClientById(id).orElseThrow (
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Cliente não encontrado"));

    }
}
