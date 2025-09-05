package com.esposito.theo.first_spring_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Indica que a classe é um controller rest. Combina @Controller e @ResponseBody.
/*
ResponseBody indica que o nosso controller é uma API que tem apenas
os endpoints que vão ser chamados pelo front end para retornar as requisições

Um controller poderia renderizar a página HTML e outras coisas que teriam algo a ver com
a junção do front com o backend.
Ou seja, nosso controller vai lidar apenas com o back end da aplicação

API's podem ser:
- Stateless (caso das REST): A cada nova request, recebo todas as informações que preciso para realizar a
funcionalidade que o cliente tá pedindo. Ex: ao excluir algum dado (um post do facebook), envio o token,
qual post quero excluir e, talvez, mais uma informação sobre se quero excluir ou arquivar. O mais
comum é enviarmos um TOKEN.

- Stateful: vai manter, dentro dela, o estado de cada cliente no servidor. Ex: vou "fazer
um login/me identificar" e, na próxima request não vou precisar mandar esses dados novamente
porque vão guardar o meu estado (autenticado ou não, oq eu fiz anteriormente, etc).
 */

/*
Agora que já temos uma classe com a anotação RestController
Queremos criar um endpoint e já temos uma classe que represente um rest controller e preciso
MAPEAR os meus endpoints.
Ou seja, queremos saber qual path o meu endpoint vai responder
*/
@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {
    // Pode responder nos métodos: post, get, delete, put, patch, options, head
    // Preciso dizer pro Spring qual métdo HTTP o meu métdo vai responder:
    
    // GET /hello-world (com GetMapping sem parâmetro) ou
    // /hello-world/get (acessaria com localhost:8080/hello-world/get
    @GetMapping
    public String helloWorld(){
        ;
    }

    // 8080 é a porta padrão! Para alterar, vamos para resources/application.properties
    // e colocamos: server.port=3000

    /*
    Nesse arquivo, podemos incluir também, p. ex, configurações para o banco de dadoos:
    spring.datasource.url=jdbc:mysql://localhost:3306/first-sprint-app
    spring.datasource.username=root
    spring.datasource.password=root

    Também poderíamos usar variáveis de ambiente:
    spring.datasource.password=${DB_PASSWORD}
     */

    /*
    O Spring tem os "perfis de configurações", para caso uma aplicação esteja rodando em
    diferentes ambientes. Ex: ambiente de produção, ambientes de teste (que a equipe usa
    para testar a aplicação antes de disponibilizar para o cliente, mesmo que esteja em deploy)

     Bastaria criar o arquivo application-dev.properties e usar a anotacao @Profile("dev")
     Ou...
     spring.profiles.active=${ACTIVE_PROFILE:dev}
     Dessa forma, posso procurar a var de ambiente ACTIVE_PROFILE e, se não achar, usa o valor de
     dev.

     Pra passar as var de ambiente, basta ir nas configurações de execução do IntelliJ e adicionar
     a var de ambiente:
     ACTIFE_PROFILE=default
     */

    // Enfim, existem muitas outras configurações
}
