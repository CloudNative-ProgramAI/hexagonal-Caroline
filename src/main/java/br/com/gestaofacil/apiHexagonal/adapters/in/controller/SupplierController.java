package br.com.gestaofacil.apiHexagonal.adapters.in.controller;

import br.com.gestaofacil.apiHexagonal.adapters.in.controller.mapper.SupplierMapper;
import br.com.gestaofacil.apiHexagonal.adapters.in.controller.request.SupplierRequest;
import br.com.gestaofacil.apiHexagonal.adapters.in.controller.response.SupplierResponse;
import br.com.gestaofacil.apiHexagonal.application.core.domain.Supplier;
import br.com.gestaofacil.apiHexagonal.application.ports.in.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/supplier")
public class SupplierController {

    @Autowired
    private InsertSupplierInputPort insertSupplierInputPort;

    @Autowired
    private FindAllSuppliersInputPort findAllSuppliersInputPort;

    @Autowired
    private FindSupplierByIdInputPort findSupplierByIdInputPort;

    @Autowired
    private UpdateSupplierInputPort updateSupplierInputPort;

    @Autowired
    private DeleteSupplierInputPort deleteSupplierInputPort;

    @Autowired
    private SupplierMapper supplierMapper;


    @PostMapping
    public ResponseEntity<Void> insetSupplier(@Valid @RequestBody SupplierRequest supplierRequest) {
        Supplier supplier = supplierMapper.toSupplier(supplierRequest);
        insertSupplierInputPort.insertSupplier(supplier);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<SupplierResponse>> findAllSuppliers() {
        return ResponseEntity.ok(supplierMapper.toSupplerResponseList(findAllSuppliersInputPort.findAllSuppliers()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponse> findSupplierById(@PathVariable final Long id) {
        return ResponseEntity.ok().body(supplierMapper.toSupplierResponse(findSupplierByIdInputPort.findSupplierById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSupplier(@PathVariable final Long id, @RequestBody SupplierRequest supplierRequest) {
        Supplier supplier = supplierMapper.toSupplier(supplierRequest);
        supplier.setId(id);
        updateSupplierInputPort.updateSupplier(supplier);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable final Long id) {
        deleteSupplierInputPort.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }

}
