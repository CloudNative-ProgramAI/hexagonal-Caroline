package br.com.gestaofacil.apiHexagonal.config;

import br.com.gestaofacil.apiHexagonal.application.core.usecase.FindAllSuppliersUseCase;
import br.com.gestaofacil.apiHexagonal.application.ports.in.FindAllSuppliersInputPort;
import br.com.gestaofacil.apiHexagonal.application.ports.out.FindAllSuppliersOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindAllSuppliersConfig {

    @Bean
    public FindAllSuppliersInputPort findAllSuppliersInputPort(FindAllSuppliersOutputPort findAllSuppliersOutputPort) {
        return new FindAllSuppliersUseCase(findAllSuppliersOutputPort);
    }
}
