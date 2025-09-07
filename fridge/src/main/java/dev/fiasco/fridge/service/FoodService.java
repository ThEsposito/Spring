package dev.fiasco.fridge.service;

import dev.fiasco.fridge.model.Food;
import dev.fiasco.fridge.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    // Cria o construtor pra injetar as dependências
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    // O findAll() vem do Jpa e faz a uma query no banco de dados para listar
    // Read
    public List<Food> getAll(){ return foodRepository.findAll();}

    // O .save() precisa receber uma ENTIDADE como parâmetro

    // Create
    public Food save(Food food){ return foodRepository.save(food); }

    // Delete
    public void delete(Long id){ foodRepository.deleteById(id); }

}
