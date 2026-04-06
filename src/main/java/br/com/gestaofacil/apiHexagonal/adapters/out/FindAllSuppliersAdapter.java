package br.com.gestaofacil.apiHexagonal.adapters.out;

import br.com.gestaofacil.apiHexagonal.adapters.out.repository.SupplierRepository;
import br.com.gestaofacil.apiHexagonal.adapters.out.repository.mapper.SupplierEntityMapper;
import br.com.gestaofacil.apiHexagonal.application.core.domain.Supplier;
import br.com.gestaofacil.apiHexagonal.application.ports.out.FindAllSuppliersOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllSuppliersAdapter implements FindAllSuppliersOutputPort {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierEntityMapper supplierEntityMapper;


    @Override
    public List<Supplier> findAllSuppliers() {
        return supplierRepository.findAll().stream()
                .map(supplierEntityMapper::toSupplierDomain)
                .toList();
    }
}
