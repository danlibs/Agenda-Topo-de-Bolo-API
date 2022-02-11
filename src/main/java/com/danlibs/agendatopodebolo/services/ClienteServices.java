package com.danlibs.agendatopodebolo.services;

import com.danlibs.agendatopodebolo.models.Cliente;

import java.util.Map;
import java.util.Optional;

public interface ClienteServices {
    Map<Long, String> verPedidosDeCliente(Long id);

    Optional<Cliente> verClientePorId(Long id);

    Boolean existe(Long id);

    Iterable<Cliente> verClientes();

    void inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

}
