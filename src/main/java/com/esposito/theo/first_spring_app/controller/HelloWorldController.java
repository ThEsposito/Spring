package com.esposito.theo.first_spring_app.controller;

import org.springframework.web.bind.annotation.RestController;

// indica que a classe é um controller rest. Combina @Controller e @ResponseBody.
/*
ResponseBody indica que o nosso controller é uma API que tem apenas
os endpoints que vao ser chamados pelo front end para retornar as requisicoes

Um controller poderia renderizar a página HTML e outras coisas que teriam algo a ver com
a junção do front com o backend

Ou seja, uma API que vai lidar apenas com o back end da nossa aplicação.

API's podem ser:
- Stateless (caso das REST): A cada nova request, recebo todas as informações que preciso para realizar a
funcionalidade que o cliente tá pedindo. Ex: ao excluir algum dado (um post do facebook), envio o token,
qual post quero excluir e, talvez, mais uma informação sobre se quero excluir ou arquivar. O mais
comum é enviarmos um TOKEN.

- Statefull: vai manter, dentro dela, o estado de cada cliente no servidor. Ex: vou "fazer
um login/me identificar" e, na próxima request não vou precisar mandar esses dados novamente
porque vão guardar o meu estado (autenticado ou não, oq eu fiz anteriormente, etc).

 */
@RestController
public class HelloWorldController {
}
