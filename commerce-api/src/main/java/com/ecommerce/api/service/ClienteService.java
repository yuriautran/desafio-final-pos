package com.ecommerce.api.service;

import com.ecommerce.api.model.dto.ClienteDto;
import com.ecommerce.api.model.entity.Cliente;
import com.ecommerce.api.repository.ClienteRepository;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Flux<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Flux<Cliente> findByNome(String nome) {
        return clienteRepository.findByNomeContains(nome);
    }

    public Mono<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public Mono<Void> deleteById(Long id) {
        return clienteRepository.deleteById(id);
    }

    public Mono<Long> countClientes() {
        return clienteRepository.count();
    }

    public Mono<Cliente> save(Mono<Cliente> mono) {
        return mono
                .flatMap(clienteRepository::save);
    }

    public Mono<Cliente> updateClient(Cliente existingClient, Cliente clienteNovo) {
        return Mono.just(clienteNovo)
                .flatMap(c -> {
                    existingClient.setEmail(c.getEmail());
                    existingClient.setNome(c.getNome());
                    return clienteRepository.save(existingClient);
                });

    }
}
