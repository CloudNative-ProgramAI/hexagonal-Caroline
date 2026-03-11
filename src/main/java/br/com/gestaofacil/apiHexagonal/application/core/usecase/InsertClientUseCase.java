package br.com.gestaofacil.apiHexagonal.application.core.usecase;

import br.com.gestaofacil.apiHexagonal.application.core.domain.Client;
import br.com.gestaofacil.apiHexagonal.application.ports.in.InsertClientInputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.InsertClientOutputPort;

public class InsertClientUseCase implements InsertClientInputPort {

    private final InsertClientOutputPort insertClientOutputPort;

    public InsertClientUseCase(InsertClientOutputPort insertClientOutputPort){
        this.insertClientOutputPort = insertClientOutputPort;
    }

    @Override
    public void insert(Client client) {
        insertClientOutputPort.insert(client);

    }
}
