package br.com.gestaofacil.apiHexagonal.adapters.out.repository.entity;

import br.com.gestaofacil.apiHexagonal.application.core.domain.TipoSupplierEnum;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "supplier")
@Entity
public class SupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeFantasia;

    private String email;

    private String cnpj;

    @Enumerated(EnumType.STRING)
    private TipoSupplierEnum tipoSupplier;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private AddressEntity address;
}
