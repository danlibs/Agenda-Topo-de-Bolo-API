package com.danlibs.agendatopodebolo.controllers;

import com.danlibs.agendatopodebolo.models.TopoDeBolo;
import com.danlibs.agendatopodebolo.services.TopoDeBoloServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("agenda")
public class AgendaTopoRestController {
    @Autowired
    private TopoDeBoloServices topoDeBoloServices;

    @GetMapping
    public ResponseEntity<Iterable<TopoDeBolo>> verAgendaCompleta() {
        return ResponseEntity.ok(topoDeBoloServices.verAgendaCompleta());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopoDeBolo> verificarPedidoId(@PathVariable Long id) {
        return ResponseEntity.ok(topoDeBoloServices.verificarPedido(id));
    }


    @PostMapping
    public ResponseEntity<TopoDeBolo> novoPedido(@RequestBody TopoDeBolo topoDeBolo) {
        topoDeBoloServices.novoPedido(topoDeBolo);
        return ResponseEntity.ok(topoDeBolo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopoDeBolo> atualizarPedido(@PathVariable Long id, @RequestBody TopoDeBolo topoDeBolo) {
        topoDeBoloServices.atualizarPedido(id, topoDeBolo);
        return ResponseEntity.ok(topoDeBolo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarPedido(@PathVariable Long id) {
        topoDeBoloServices.apagarPedido(id);
        return ResponseEntity.ok().build();
    }

}
