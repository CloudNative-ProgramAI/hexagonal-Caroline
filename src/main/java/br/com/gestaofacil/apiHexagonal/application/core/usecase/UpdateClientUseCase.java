package br.com.gestaofacil.apiHexagonal.application.core.usecase;

import br.com.gestaofacil.apiHexagonal.application.core.domain.Client;
import br.com.gestaofacil.apiHexagonal.application.ports.in.UpdateClientInputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.FindClientByIdOutputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.UpdateClientOutputPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UpdateClientUseCase implements UpdateClientInputPort {

    private final UpdateClientOutputPort updateClientOutputPort;

    private final FindClientByIdOutputPort findClientByIdOutputPort;

    public UpdateClientUseCase(UpdateClientOutputPort updateClientOutputPort, FindClientByIdOutputPort findClientByIdOutputPort){
        this.updateClientOutputPort = updateClientOutputPort;
        this.findClientByIdOutputPort = findClientByIdOutputPort;
    }

    @Override
    public void updateClient(Client client) {
        Client clientUpdate = findClientByIdOutputPort.findClientById(client.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado"));

        clientUpdate.setName(client.getName());
        clientUpdate.setCpf(client.getCpf());
        clientUpdate.setEmail(client.getEmail());

        updateClientOutputPort.updateClient(clientUpdate);
    }
}
