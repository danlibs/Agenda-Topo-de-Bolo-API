package com.danlibs.agendatopodebolo.services;

import com.danlibs.agendatopodebolo.models.TopoDeBolo;

public interface TopoDeBoloServices {
    Iterable<TopoDeBolo> verAgendaCompleta();

    TopoDeBolo verificarPedido(Long id);

    void novoPedido(TopoDeBolo topo);

    void atualizarPedido(Long id, TopoDeBolo topo);

    void apagarPedido(Long id);

}
