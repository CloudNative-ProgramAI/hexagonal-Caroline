package br.com.gestaofacil.apiHexagonal.adapters.in.controller.mapper;

import br.com.gestaofacil.apiHexagonal.adapters.in.controller.request.AddressDTO;
import br.com.gestaofacil.apiHexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toAddress(AddressDTO address);

    AddressDTO toAddressDTO(Address address);
}
