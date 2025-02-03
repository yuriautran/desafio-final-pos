package com.ecommerce.api.repository;

import com.ecommerce.api.model.entity.Cliente;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteRepository extends ReactiveCrudRepository<Cliente, Long> {
    Flux<Cliente> findByNomeContains(String nome);
}
