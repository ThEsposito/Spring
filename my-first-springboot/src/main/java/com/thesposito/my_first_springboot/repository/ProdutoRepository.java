package com.thesposito.my_first_springboot.repository;

import com.thesposito.my_first_springboot.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {}

// Referências:
// https://www.devmedia.com.br/jpa-como-usar-a-anotacao-generatedvalue/38592