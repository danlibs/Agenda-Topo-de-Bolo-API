package com.danlibs.agendatopodebolo.controllers;

import com.danlibs.agendatopodebolo.models.Cliente;
import com.danlibs.agendatopodebolo.services.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("clientes")
public class ClienteController {
    @Autowired
    private ClienteServices clienteService;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> verClientes() {
        return ResponseEntity.ok(clienteService.verClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<Long, String>> verPedidosDeCliente(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(clienteService.verPedidosDeCliente(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> inserirCliente(@RequestBody Cliente cliente) {
        clienteService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable(value = "id") Long id, @RequestBody Cliente cliente) {
        clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }
}
