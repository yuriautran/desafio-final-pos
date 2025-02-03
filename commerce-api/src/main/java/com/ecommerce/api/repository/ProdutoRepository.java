package com.ecommerce.api.repository;

import com.ecommerce.api.model.entity.Produto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProdutoRepository extends ReactiveCrudRepository<Produto, Long> {
}
