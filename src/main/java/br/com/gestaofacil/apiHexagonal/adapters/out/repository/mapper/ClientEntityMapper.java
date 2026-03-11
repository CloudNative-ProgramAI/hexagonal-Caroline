package br.com.gestaofacil.apiHexagonal.adapters.out.repository.mapper;

import br.com.gestaofacil.apiHexagonal.adapters.out.repository.entity.ClientEntity;
import br.com.gestaofacil.apiHexagonal.application.core.domain.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientEntityMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "cpf", source = "cpf")
    @Mapping(target = "email", source = "email")
    ClientEntity toClientEntity(Client client);

    Client toClient(ClientEntity clientEntity);
}
