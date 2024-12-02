package com.app.carros.entity;

public class Carro {

    private String nome;
    private String marca;
    private String modelo;
    private int ano;

    public int getAno() {
        return ano;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Carro(String nome, String marca, String modelo, int ano) {
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }
}
