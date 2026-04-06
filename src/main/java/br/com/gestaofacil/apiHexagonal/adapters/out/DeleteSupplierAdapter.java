package br.com.gestaofacil.apiHexagonal.adapters.out;

import br.com.gestaofacil.apiHexagonal.adapters.out.repository.SupplierRepository;
import br.com.gestaofacil.apiHexagonal.adapters.out.repository.mapper.SupplierEntityMapper;
import br.com.gestaofacil.apiHexagonal.application.ports.out.DeleteSupplierOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("deleteSupplierAdapter")
public class DeleteSupplierAdapter implements DeleteSupplierOutputPort {

    @Autowired
    private SupplierRepository supplierRepository;


    @Override
    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);

    }
}
