package br.com.gestaofacil.apiHexagonal.application.core.usecase;

import br.com.gestaofacil.apiHexagonal.application.core.domain.Client;
import br.com.gestaofacil.apiHexagonal.application.ports.in.FindAllClientsInputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.FindAllClientsOutputPort;

import java.util.List;

public class FindAllClientsUseCase implements FindAllClientsInputPort {

    private final FindAllClientsOutputPort findAllClientsOutputPort;

    public FindAllClientsUseCase(FindAllClientsOutputPort findAllClientsOutputPort) {
        this.findAllClientsOutputPort = findAllClientsOutputPort;
    }

    @Override
    public List<Client> findAllClients() {
        return findAllClientsOutputPort.findAllClients();
    }
}
