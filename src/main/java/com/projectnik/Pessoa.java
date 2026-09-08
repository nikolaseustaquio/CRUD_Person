package com.projectnik;


public class Pessoa {
    private int id;
    private String nome;
    private int idade;
    private String ocupacao;

    public Pessoa(int id, String nome, int idade, String ocupacao){
        this.nome = nome;
        this.idade = idade;
        this.ocupacao = ocupacao;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    @Override
    public String toString() {
        return String.format("""
                ID: %d | NOME: %s
                IDADE: %d | OCUPAÇÂO: %s
                """, getId(), getNome(), getIdade(), getOcupacao());
    }
}
