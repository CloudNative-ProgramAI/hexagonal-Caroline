package br.com.gestaofacil.apiHexagonal.config;

import br.com.gestaofacil.apiHexagonal.application.core.usecase.FindAllClientsUseCase;
import br.com.gestaofacil.apiHexagonal.application.ports.in.FindAllClientsInputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.FindAllClientsOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindAllClientsConfig {

    @Bean
    public FindAllClientsInputPort findAllClientsInputPort(FindAllClientsOutputPort findAllClientsOutputPort) {
        return new FindAllClientsUseCase(findAllClientsOutputPort);
    }
}
