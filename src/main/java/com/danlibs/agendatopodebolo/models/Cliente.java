package com.danlibs.agendatopodebolo.models;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    @ManyToOne
    private Endereco endereco;
    @ElementCollection
    private Map<Long, String> pedidos;

    public Map<Long, String> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Map<Long, String> pedidos) {
        this.pedidos = pedidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
