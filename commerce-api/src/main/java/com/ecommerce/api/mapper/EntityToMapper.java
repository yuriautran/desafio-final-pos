package com.ecommerce.api.mapper;

import com.ecommerce.api.model.dto.ClienteDto;
import com.ecommerce.api.model.entity.Cliente;

public class EntityToMapper {

    public static ClienteDto toClienteDto(Cliente cliente) {
        return new ClienteDto(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail()
        );
    }

    public static Cliente toCliente(ClienteDto clienteDto) {
        return new Cliente(
                clienteDto.getId(),
                clienteDto.getNome(),
                clienteDto.getEmail()
        );
    }
}
