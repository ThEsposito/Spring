package com.esposito.theo.first_spring_app.service;
import org.springframework.stereotype.Service;

// As classes Service contém toda a lógica da aplicação/regras de negócio. Incluindo
// o acesso aos repositories (classes de conexão ao banco de dados)
// O controller recebe a requisição e passa o processamento pro Service

/*
O @Service indica pro Spring que a classe é uma classe de service e está sendo gerenciada
pelo Spring.

Dessa forma, qquer classe que pedir uma instância de Service, o Spring já consegue gerenciar
a injeção dessa dependência na outra classe.
*/


@Service
public class HelloWorldService {
    public String helloWorld(String name){
        return "Hello, "+name+'!';
    }
}
