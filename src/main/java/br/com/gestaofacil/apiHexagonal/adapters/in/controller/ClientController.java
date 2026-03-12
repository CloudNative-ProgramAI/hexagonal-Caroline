package br.com.gestaofacil.apiHexagonal.adapters.in.controller;

import br.com.gestaofacil.apiHexagonal.adapters.in.controller.mapper.ClientMapper;
import br.com.gestaofacil.apiHexagonal.adapters.in.controller.request.ClientRequest;
import br.com.gestaofacil.apiHexagonal.adapters.in.controller.response.ClientResponse;
import br.com.gestaofacil.apiHexagonal.application.core.domain.Client;
import br.com.gestaofacil.apiHexagonal.application.ports.in.FindAllClientsInputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.in.FindClientByIdInputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.in.InsertClientInputPort;
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
    FindAllClientsInputPort findAllClientsInputPort;

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


}
