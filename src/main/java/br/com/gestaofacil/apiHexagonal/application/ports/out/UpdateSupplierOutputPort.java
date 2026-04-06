package br.com.gestaofacil.apiHexagonal.application.ports.out;

import br.com.gestaofacil.apiHexagonal.application.core.domain.Supplier;

public interface UpdateSupplierOutputPort {

    void updateSupplier(Supplier supplier);
}
