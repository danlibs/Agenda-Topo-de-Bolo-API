package com.danlibs.agendatopodebolo.services.implementacoes;

import com.danlibs.agendatopodebolo.models.Cliente;
import com.danlibs.agendatopodebolo.models.ClienteRepository;
import com.danlibs.agendatopodebolo.models.Endereco;
import com.danlibs.agendatopodebolo.models.EnderecoRepository;
import com.danlibs.agendatopodebolo.services.ClienteServices;
import com.danlibs.agendatopodebolo.services.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ClienteServiceImplementacao implements ClienteServices {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;


    @Override
    public Map<Long, String> verPedidosDeCliente(Long id) {
        return clienteRepository.findById(id).get().getPedidos();
    }

    @Override
    public Optional<Cliente> verClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Boolean existe(Long id) {
        return clienteRepository.findById(id).isPresent();
    }

    @Override
    public Iterable<Cliente> verClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            cliente.setPedidos(clienteBd.get().getPedidos());
            salvarClienteCep(cliente);
        }
    }

    private void salvarClienteCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
