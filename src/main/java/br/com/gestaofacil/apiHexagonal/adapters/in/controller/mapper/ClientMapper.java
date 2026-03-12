package br.com.gestaofacil.apiHexagonal.adapters.in.controller.mapper;

import br.com.gestaofacil.apiHexagonal.adapters.in.controller.request.ClientRequest;
import br.com.gestaofacil.apiHexagonal.adapters.in.controller.response.ClientResponse;
import br.com.gestaofacil.apiHexagonal.application.core.domain.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toClient(ClientRequest request);

    ClientResponse toClientResponse(Client client);

    List<ClientResponse> toClientResponseList(List<Client> clientList);
}
