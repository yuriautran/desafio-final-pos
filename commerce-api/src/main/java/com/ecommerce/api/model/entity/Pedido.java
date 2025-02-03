package com.ecommerce.api.model.entity;

import com.ecommerce.api.model.enums.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.OffsetDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("pedido")
public class Pedido {

    @Id
    private Long id;
    private Long clienteId;
    private OffsetDateTime dataPedido;
    private StatusPedido status;
}
