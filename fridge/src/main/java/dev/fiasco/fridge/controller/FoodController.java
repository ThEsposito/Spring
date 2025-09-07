package dev.fiasco.fridge.controller;

import dev.fiasco.fridge.model.Food;
import dev.fiasco.fridge.service.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
Pra cada classe no Spring, utilizamos alguma anotação pra indicar o que essa classe faz.

Ele (através das annotations) injeta automaticamente as dependências e instâncias das classes
que criamos.
*/

/*
Pra eu inicializar essa dependência, posso fazer de duas maneiras:
- usando a annotation @Autowired no atributo
- ou criando um construtor que inicializa esse atributo.
*/

// Obs: o parâmetro (para o path) do RequestMapping é opcional.
// Acredito que ele possa diferenciar sozinho pelo tipo (verbo) da requisição HTTP
@RestController
@RequestMapping("/food")
public class FoodController {
    // Injeção das dependências
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/getAll")
    public List<Food> getAll() {
        return foodService.getAll();
    }

    // O RequestBody pede para mandar no corpo da request os atributos que precisamos (e
    // estão no model), por isso recebemos um objeto Food como parâmetro.
    @PostMapping("/create")
    public Food create(@RequestBody Food food){
        return foodService.save(food);
    }

    @DeleteMapping("/delete")
    public void delete(Long id){
        foodService.delete(id);
    }
}
