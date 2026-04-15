package com.thesposito.my_first_springboot.controller;

import com.thesposito.my_first_springboot.exceptions.RecursoNaoEncontradoException;
import com.thesposito.my_first_springboot.model.Produto;
import com.thesposito.my_first_springboot.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // Não passar parâmetro indica que a url da classe chama esse método por padrão
    @GetMapping()
    public List<Produto> listarProdutos(){
        return produtoService.listarProdutos();
    }

    // Preciso indicar o genérico '?' porque podemos retornar no corpo o objeto ou o erro
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProduto(@PathVariable Long id) {
        Produto p = produtoService.buscarPorId(id);
        return ResponseEntity.ok(p);
    }

    @PostMapping()
    public Produto criarProduto(@RequestBody Produto produto){
        return produtoService.salvarProduto(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
