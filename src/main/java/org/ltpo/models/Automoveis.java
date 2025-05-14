package org.ltpo.models;

import jakarta.persistence.*;


@Entity
@Table(name = "Automoveis")
public class Automoveis {
    @Id
    private int id;
    private String placa;
    private int ano;
    private String cor;
    @ManyToOne
    private Modelo modelo;

    public Automoveis(){

    }

    public Automoveis(int id, String placa, int ano, String cor, Modelo modelo) {
        this.id = id;
        this.placa = placa;
        this.ano = ano;
        this.cor = cor;
        this.modelo = modelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
}