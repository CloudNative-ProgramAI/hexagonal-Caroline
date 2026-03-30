package br.com.gestaofacil.apiHexagonal.adapters.out.repository.mapper;

import br.com.gestaofacil.apiHexagonal.adapters.out.repository.entity.SupplierEntity;
import br.com.gestaofacil.apiHexagonal.application.core.domain.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplierEntityMapper {

    @Mapping(target = "id", ignore = false)
    SupplierEntity toSupplierEntity(Supplier supplier);

    Supplier toSupplierDomain(SupplierEntity supplierEntity);

}
