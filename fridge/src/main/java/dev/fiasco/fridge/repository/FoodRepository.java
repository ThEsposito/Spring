package dev.fiasco.fridge.repository;

import dev.fiasco.fridge.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;


/*
Aqui já podemos ver o uso do JPA.
Primeiro, precisamos extender a interface JpaRepository
O JpaRepository extende a inteface ListCrudRepository
o ListCrudRepository possui os métodos:
- findAll()
- findById(Iterable<ID> ids)

e o ListCrudRepository extende a interface CrudRepository, que tem diversas operações
possíveis para se realizar em um bando de dados, como:
- findById(ID id)
- boolean existsById(ID id)
- long count()
- deleteById(ID id)
- delete(ID id)
- deleteAll()

ou seja, o CrudRepository tem todas as operações básicas que fazemos num banco de dados.
Tudo isso (as queries) já vem direto do JPA! Por isso, a gente só extende e não precisa
fazer nada além de transformar nosso FoodRepository numa interface e passar os devidos
parâmetros:
 - Qual é a classe que a gente tá tratando (nosso model)
 - O tipo do identificador (o ID): Long

Obs: JpaRepository é um generic, ent passamos isso dentro de <>.

Agora no service, a gente só injeta as dependências do Jpa, definindo um atributo dessa
interface
*/

/*
Precisamos criar o banco de dados (com nome, senha). Ele vai ser o H2 DB que importamos
no Spring Initializr.

Pra criar a tabela, podemos alterar resources/application.properties para .yml e
realizar a configuração por lá.
*/

public interface FoodRepository extends JpaRepository<Food, Long> {
}
