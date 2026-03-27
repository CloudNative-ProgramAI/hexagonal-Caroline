package br.com.gestaofacil.apiHexagonal.adapters.in.controller;

import br.com.gestaofacil.apiHexagonal.adapters.in.controller.mapper.ClientMapper;
import br.com.gestaofacil.apiHexagonal.adapters.in.controller.request.ClientRequest;
import br.com.gestaofacil.apiHexagonal.adapters.in.controller.response.ClientResponse;
import br.com.gestaofacil.apiHexagonal.application.core.domain.Client;
import br.com.gestaofacil.apiHexagonal.application.ports.in.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/clients")
public class ClientController {

    @Autowired
    private InsertClientInputPort insertClientInputPort;

    @Autowired
    private FindClientByIdInputPort findClientByIdInputPort;

    @Autowired
    private FindAllClientsInputPort findAllClientsInputPort;

    @Autowired
    private UpdateClientInputPort updateClientInputPort;

    @Autowired
    private DeleteClientInputPort deleteClientInputPort;

    @Autowired
    private ClientMapper clientMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ClientRequest clientRequest){
        Client client = clientMapper.toClient(clientRequest);
        insertClientInputPort.insert(client);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> findById(@PathVariable final Long id) {
        Client client =  findClientByIdInputPort.findClientById(id);
        ClientResponse clientResponse = clientMapper.toClientResponse(client);
        return ResponseEntity.ok().body(clientResponse);
    }

    @GetMapping
    public ResponseEntity<List<ClientResponse>> findAll() {
        return ResponseEntity.ok(clientMapper.toClientResponseList(findAllClientsInputPort.findAllClients()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateClient(@PathVariable final Long id,
                             @RequestBody ClientRequest clientRequest
    ){
        Client client = clientMapper.toClient(clientRequest);
        client.setId(id);
        updateClientInputPort.updateClient(client);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable final Long id) {
        deleteClientInputPort.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

}
