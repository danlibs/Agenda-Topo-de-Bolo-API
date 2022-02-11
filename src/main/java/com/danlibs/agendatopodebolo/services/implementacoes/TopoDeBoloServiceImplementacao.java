package com.danlibs.agendatopodebolo.services.implementacoes;

import com.danlibs.agendatopodebolo.models.TopoDeBolo;
import com.danlibs.agendatopodebolo.models.TopoDeBoloRepository;
import com.danlibs.agendatopodebolo.services.ClienteServices;
import com.danlibs.agendatopodebolo.services.TopoDeBoloServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Optional;

@Service
public class TopoDeBoloServiceImplementacao implements TopoDeBoloServices {
    @Autowired
    private TopoDeBoloRepository topoDeBoloRepository;
    @Autowired
    private ClienteServices clienteServices;

    @Override
    public Iterable<TopoDeBolo> verAgendaCompleta() {
        return topoDeBoloRepository.findAll();
    }

    @Override
    public TopoDeBolo verificarPedido(Long id) {
        return topoDeBoloRepository.findById(id).get();
    }

    @Override
    public void novoPedido(TopoDeBolo topo) {
        topo.setDataPedido(LocalDate.now());
        topoDeBoloRepository.save(topo);
        if (topo.getCliente().getPedidos() == null) {
            topo.getCliente().setPedidos(new LinkedHashMap<>());
            topo.getCliente().getPedidos().put(topo.getId(), topo.getNomeProjeto());
        } else {
            topo.getCliente().getPedidos().put(topo.getId(), topo.getNomeProjeto());
        }
        topo.getCliente().setNome(clienteServices.verClientePorId(topo.getCliente().getId()).get().getNome());
        topo.getCliente().setTelefone(clienteServices.verClientePorId(topo.getCliente().getId()).get().getTelefone());
        topo.getCliente().setEndereco(clienteServices.verClientePorId(topo.getCliente().getId()).get().getEndereco());
        clienteServices.atualizar(topo.getCliente().getId(), topo.getCliente());
        atualizarPedido(topo.getId(), topo);
    }

    @Override
    public void atualizarPedido(Long id, TopoDeBolo topo) {
        Optional<TopoDeBolo> topoId = topoDeBoloRepository.findById(id);
        if (topoId.isPresent()) {
            topo.setDataPedido(topoDeBoloRepository.findById(id).get().getDataPedido());
            topo.getCliente().setEndereco(topoDeBoloRepository.findById(id).get().getCliente().getEndereco());
            topo.getCliente().setNome(topoDeBoloRepository.findById(id).get().getCliente().getNome());
            topo.getCliente().setTelefone(topoDeBoloRepository.findById(id).get().getCliente().getTelefone());
            topo.getCliente().setPedidos(topoDeBoloRepository.findById(id).get().getCliente().getPedidos());
            topoDeBoloRepository.findById(id).get().getCliente().getPedidos().put(id, topo.getNomeProjeto());
            clienteServices.atualizar(topo.getCliente().getId(), topo.getCliente());
            topoDeBoloRepository.save(topo);
        }
    }

    @Override
    public void apagarPedido(Long id) {
        topoDeBoloRepository.findById(id).get().getCliente().getPedidos().remove(id);
        topoDeBoloRepository.deleteById(id);
    }
}
