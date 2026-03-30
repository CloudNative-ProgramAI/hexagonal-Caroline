package br.com.gestaofacil.apiHexagonal.application.core.domain;

public class Supplier {

    private Long id;

    private String nomeFantasia;

    private String email;

    private String cnpj;

    private TipoSupplierEnum tipoSupplier;

    private Address address;

    public Supplier(Long id, String nomeFantasia, String email, String cnpj, TipoSupplierEnum tipoSupplier, Address address) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.email = email;
        this.cnpj = cnpj;
        this.tipoSupplier = tipoSupplier;
        this.address = address;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public TipoSupplierEnum getTipoSupplier() {
        return tipoSupplier;
    }

    public void setTipoSupplier(TipoSupplierEnum tipoSupplier) {
        this.tipoSupplier = tipoSupplier;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
