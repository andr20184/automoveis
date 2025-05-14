package org.ltpo.models;

import jakarta.persistence.*;
import org.ltpo.enuns.Tipo;
import java.util.List;


@Entity
@Table(name = "Usuarios")
public class Usuarios {
    @Id
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo-usuario",nullable = false)
    private Tipo tipo;
    private String nome;
    private String telefone;
    @OneToMany
    private List<Automoveis>automovels;

    public Usuarios(){

    }

    public Usuarios(int id,String nome,String telefone,Tipo tipo,List<Automoveis>automovels){
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.tipo = tipo;
        this.automovels = automovels;
    }

    public int getId() {
        return id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<Automoveis> getAutomovels() {
        return automovels;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setAutomovels(List<Automoveis> automovels) {
        this.automovels = automovels;
    }
}
