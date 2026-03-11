package br.com.gestaofacil.apiHexagonal.adapters.out.repository;

import br.com.gestaofacil.apiHexagonal.adapters.out.repository.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
