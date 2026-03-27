package br.com.gestaofacil.apiHexagonal.adapters.out;

import br.com.gestaofacil.apiHexagonal.adapters.out.repository.ClientRepository;
import br.com.gestaofacil.apiHexagonal.application.ports.out.DeleteClientOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("deleteClientAdapter")
public class DeleteClientAdapter implements DeleteClientOutputPort {

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
