package br.com.gestaofacil.apiHexagonal.application.ports.out;

import br.com.gestaofacil.apiHexagonal.application.core.domain.Supplier;

public interface InsertSupplierOutputPort {

    void insertSupplier(Supplier supplier);
}
