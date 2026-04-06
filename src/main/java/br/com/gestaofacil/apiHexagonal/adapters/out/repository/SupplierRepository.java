package br.com.gestaofacil.apiHexagonal.adapters.out.repository;

import br.com.gestaofacil.apiHexagonal.adapters.out.repository.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {
}
