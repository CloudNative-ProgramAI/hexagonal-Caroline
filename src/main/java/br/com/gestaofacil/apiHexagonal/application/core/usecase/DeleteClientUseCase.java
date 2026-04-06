package br.com.gestaofacil.apiHexagonal.application.core.usecase;

import br.com.gestaofacil.apiHexagonal.application.ports.in.DeleteClientInputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.DeleteClientOutputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.FindClientByIdOutputPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DeleteClientUseCase implements DeleteClientInputPort {

    private final DeleteClientOutputPort deleteClientOutputPort;

    private final FindClientByIdOutputPort findClientByIdOutputPort;

    public DeleteClientUseCase(DeleteClientOutputPort deleteClientOutputPort, FindClientByIdOutputPort findClientByIdOutputPort) {
        this.deleteClientOutputPort = deleteClientOutputPort;
        this.findClientByIdOutputPort = findClientByIdOutputPort;
    }

    @Override
    public void deleteClient(Long id) {
        findClientByIdOutputPort.findClientById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado"));

        deleteClientOutputPort.deleteClient(id);
    }
}
