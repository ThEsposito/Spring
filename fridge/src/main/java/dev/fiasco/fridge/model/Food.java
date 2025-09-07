package dev.fiasco.fridge.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/*
O entity é uma anotação muito forte para um model. Vai dizer que isso é uma entidade
do meu banco de dados. Toda essa classe aqui vai ser persistida na minha camada de
repository, que por sua vez se conecta com o banco de dados.

Ou seja, pra cada atributo que temos aqui vai ter uma tabela no banco de dados com uma
coluna pra cada característica.
*/

/*
O table guarda o nome da tabela no banco de dados, mas não é obrigatório dar um nome
para a tabela.
 */

/*
Quando conectamos algo ao BD, ele precisa ter uma ordem lógica, caso ele seja um BD
sequencial (SQL): pra isso o ID.

O @Id faz com que o Spring gere o id automaticamente.
Pra passar uma "estratégia" para gerar esse id, usamos a annotation:
@GenerationValue(strategy = GenerationType.IDENTITY)

Esse GenerationType é autoincremental (começando de 1?)
 */
@Entity
@Table(name = "food_table")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime expirationDate; // Vou ter que definir um bean pra essa classe?
    private Integer quantity;

    public Food(Long id, String name, LocalDateTime expirationDate, Integer quantity) {
        this.id = id;
        this.name = name;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
