package br.com.gestaofacil.apiHexagonal.application.core.usecase;

import br.com.gestaofacil.apiHexagonal.application.ports.in.DeleteSupplierInputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.DeleteSupplierOutputPort;

public class DeleteSupplierUseCase implements DeleteSupplierInputPort {

    private final DeleteSupplierOutputPort deleteSupplierOutputPort;

    public DeleteSupplierUseCase(DeleteSupplierOutputPort deleteSupplierOutputPort) {
        this.deleteSupplierOutputPort = deleteSupplierOutputPort;
    }

    @Override
    public void deleteSupplier(Long id) {
        deleteSupplierOutputPort.deleteSupplier(id);
    }
}
