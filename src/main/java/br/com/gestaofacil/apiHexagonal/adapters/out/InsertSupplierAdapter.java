package br.com.gestaofacil.apiHexagonal.adapters.out;

import br.com.gestaofacil.apiHexagonal.adapters.out.repository.SupplierRepository;
import br.com.gestaofacil.apiHexagonal.adapters.out.repository.entity.SupplierEntity;
import br.com.gestaofacil.apiHexagonal.adapters.out.repository.mapper.SupplierEntityMapper;
import br.com.gestaofacil.apiHexagonal.application.core.domain.Supplier;
import br.com.gestaofacil.apiHexagonal.application.ports.out.InsertSupplierOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertSupplierAdapter implements InsertSupplierOutputPort {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierEntityMapper supplierEntityMapper;


    @Override
    public void insertSupplier(Supplier supplier) {
        SupplierEntity supplierEntity = supplierEntityMapper.toSupplierEntity(supplier);
        supplierRepository.save(supplierEntity);
    }
}
