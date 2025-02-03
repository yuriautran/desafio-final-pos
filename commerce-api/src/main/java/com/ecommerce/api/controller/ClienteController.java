package com.ecommerce.api.controller;

import com.ecommerce.api.mapper.EntityToMapper;
import com.ecommerce.api.model.dto.ClienteDto;
import com.ecommerce.api.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private static final Logger log = LoggerFactory.getLogger(ClienteController.class);

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public Flux<ClienteDto> findAll() {
        return clienteService.findAll()
                .map(EntityToMapper::toClienteDto);
    }

    @GetMapping("nome")
    public Flux<ClienteDto> findByNome(@RequestParam String nome) {
        return clienteService.findByNome(nome)
                .map(EntityToMapper::toClienteDto);
    }

    @GetMapping("id")
    public Mono<ClienteDto> findById(@RequestParam Long id) {
        return clienteService.findById(id)
                .map(EntityToMapper::toClienteDto);
    }

    @DeleteMapping("id/{id}")
    public Mono<ResponseEntity> deleteById(@PathVariable Long id) {
        return clienteService.deleteById(id)
                .then(Mono.defer(clienteService::countClientes))
                .map(count -> ResponseEntity.ok().body("Quantidade de clientes atualizada: " + count));
    }

    @PostMapping()
    public Mono<ClienteDto> save(@RequestBody Mono<ClienteDto> mono) {
        return mono
                .map(EntityToMapper::toCliente)
                .transform(clienteService::save)
                .map(EntityToMapper::toClienteDto);
    }

    @PutMapping("id/{id}")
    public Mono<ClienteDto> update(@PathVariable Long id, @RequestBody ClienteDto cliente) {
        return clienteService.findById(id)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Id " + id + " não encontrado")))
                .flatMap(existingClient -> {
                    return Mono.just(cliente)
                            .map(EntityToMapper::toCliente)
                            .flatMap(c -> clienteService.updateClient(existingClient, c)
                            .map(EntityToMapper::toClienteDto)
                            );
                });
    }
}
