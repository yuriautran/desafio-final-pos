package com.ecommerce.api.model.dto;


import com.ecommerce.api.model.enums.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {

    private ClienteDto clienteDto;
    private List<ProdutoDto> listProdutoDto;
    private Double valorTotal;
    private StatusPedido statusPedido;

}
