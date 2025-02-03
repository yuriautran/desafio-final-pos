package com.ecommerce.api.repository;

import com.ecommerce.api.model.entity.Pedido;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PedidoRepository extends ReactiveCrudRepository<Pedido, Long> {
}
