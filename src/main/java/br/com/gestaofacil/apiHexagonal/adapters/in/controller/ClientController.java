package br.com.gestaofacil.apiHexagonal.adapters.in.controller;

import br.com.gestaofacil.apiHexagonal.adapters.in.controller.mapper.ClientMapper;
import br.com.gestaofacil.apiHexagonal.adapters.in.controller.request.ClientRequest;
import br.com.gestaofacil.apiHexagonal.application.core.domain.Client;
import br.com.gestaofacil.apiHexagonal.application.ports.in.InsertClientInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/clients")
public class ClientController {

    @Autowired
    private InsertClientInputPort insertClientInputPort;

    @Autowired
    private ClientMapper clientMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ClientRequest clientRequest){
        Client client = clientMapper.toClient(clientRequest);
        insertClientInputPort.insert(client);
        return ResponseEntity.ok().build();
    }
}
