package br.com.gestaofacil.apiHexagonal.application.core.usecase;

import br.com.gestaofacil.apiHexagonal.application.core.domain.Supplier;
import br.com.gestaofacil.apiHexagonal.application.ports.in.InsertSupplierInputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.InsertSupplierOutputPort;

public class InsertSupplierUseCase implements InsertSupplierInputPort {

    private final InsertSupplierOutputPort insertSupplierOutputPort;

    public InsertSupplierUseCase(InsertSupplierOutputPort insertSupplierOutputPort) {
        this.insertSupplierOutputPort = insertSupplierOutputPort;
    }


    @Override
    public void insertSupplier(Supplier supplier) {
        insertSupplierOutputPort.insertSupplier(supplier);
    }
}
