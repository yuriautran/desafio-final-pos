package com.ecommerce.api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("cliente_pedido")
public class ClientePedido {

    @Id
    private Long id;
    private Long idCliente;
    private Long idPedido;
    private Double valorTotal;
}
