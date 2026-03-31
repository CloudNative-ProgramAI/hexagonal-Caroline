package br.com.gestaofacil.apiHexagonal.adapters.out.repository.mapper;

import br.com.gestaofacil.apiHexagonal.adapters.out.repository.entity.SupplierEntity;
import br.com.gestaofacil.apiHexagonal.application.core.domain.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SupplierEntityMapper {

    @Mapping(target = "id", ignore = false)
    SupplierEntity toSupplierEntity(Supplier supplier);

    Supplier toSupplierDomain(SupplierEntity supplierEntity);

    void updateEntityFromDomain(Supplier supplier, @MappingTarget SupplierEntity supplierEntity);
}
