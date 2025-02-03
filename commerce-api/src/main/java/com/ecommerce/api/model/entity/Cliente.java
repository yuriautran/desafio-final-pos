package com.ecommerce.api.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("cliente")
public class Cliente {

    @Id
    private Long id;
    private String nome;
    private String email;
}
