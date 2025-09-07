package com.esposito.theo.first_spring_app.configuration;

// Classes de configuração no Spring são utilizadas para definir beans e instâncias de classe

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

/*
O Spring consegue fazer gerenciamento das classes que são componentes do Spring e que foram
mapeadas diretamente por nós (com as anotações, creio eu).

Mas se precisarmos que o Spring faça a injeção das dependências de CLASSES EXTERNAS (usando Autowired)
o Spring não vai conseguir mapear pra gente se não fizermos a configuração.

Pra isso, usamos as classes de configuração,
*/
@Configuration
public class HelloConfiguration {

    // Essas classes seguirão o padrão Singleton. Então toda vez que tivermos um parâmetro que seja
    // Objeto de uma classe, serão A MESMA INSTÂNCIA!

    @Bean
    public MyServiceInterface myService(){
        return new MyServiceImplementation();
    }
}
