package br.com.gestaofacil.apiHexagonal.adapters.in.controller.mapper;

import br.com.gestaofacil.apiHexagonal.adapters.in.controller.request.SupplierRequest;
import br.com.gestaofacil.apiHexagonal.adapters.in.controller.response.SupplierResponse;
import br.com.gestaofacil.apiHexagonal.application.core.domain.Supplier;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    Supplier toSupplier(SupplierRequest supplierRequest);

    SupplierResponse toSupplierResponse(Supplier supplier);

    List<SupplierResponse> toSupplerResponseList(List<Supplier> supplerList);

}
