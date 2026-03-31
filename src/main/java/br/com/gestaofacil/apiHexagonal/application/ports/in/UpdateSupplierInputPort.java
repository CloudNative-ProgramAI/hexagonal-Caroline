package br.com.gestaofacil.apiHexagonal.application.ports.in;

import br.com.gestaofacil.apiHexagonal.application.core.domain.Supplier;

public interface UpdateSupplierInputPort {

    void updateSupplier(Supplier supplier);
}
