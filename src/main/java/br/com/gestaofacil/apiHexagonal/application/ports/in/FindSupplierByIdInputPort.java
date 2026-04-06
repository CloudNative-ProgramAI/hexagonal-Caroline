package br.com.gestaofacil.apiHexagonal.application.ports.in;

import br.com.gestaofacil.apiHexagonal.application.core.domain.Supplier;

public interface FindSupplierByIdInputPort {

    Supplier findSupplierById(Long id);
}
