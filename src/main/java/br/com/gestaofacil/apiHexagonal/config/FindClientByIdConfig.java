package br.com.gestaofacil.apiHexagonal.config;

import br.com.gestaofacil.apiHexagonal.application.core.usecase.FindClientByIdUseCase;
import br.com.gestaofacil.apiHexagonal.application.ports.in.FindClientByIdInputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.FindClientByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindClientByIdConfig {

    @Bean
    public FindClientByIdInputPort findClientByIdInputPort (FindClientByIdOutputPort findClientByIdOutputPort) {
        return new FindClientByIdUseCase(findClientByIdOutputPort);
    }
}
