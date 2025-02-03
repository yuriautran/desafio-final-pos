package com.ecommerce.api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("pedido_produto")
public class PeditoProduto {

    @Id
    private Long id;
    private Long produtoId;
    private Long pedidoId;
    private Integer quantidade;
    private Double precoUnitario;
}