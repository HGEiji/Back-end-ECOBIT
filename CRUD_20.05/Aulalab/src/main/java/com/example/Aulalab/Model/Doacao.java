package com.example.Aulalab.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doacao {

    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    private long id;
    private String descricao;

    private String nome;
    private boolean estatus;
    private int quantidade;
    private String categoria;

    public Doacao() {

    }




    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public int getQuatidade() {
        return quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public void setDescricao(String descricao) {
        if(descricao.isBlank()){
            throw new IllegalArgumentException("Campo obrigatório");
        } else{
            this.descricao = descricao;
        }
    }

    public void setNome(String nome) {
        if(nome.isBlank()){
            throw new IllegalArgumentException("Campo obrigatório");
        } else {
            this.nome = descricao;
        }
    }

    public void setEstatus(boolean estatus) {

        this.estatus = estatus;
    }

    public void setQuatidade(int quantidade) {
        try{
            if (quantidade <= 0 ){
                throw new IllegalArgumentException("Quantidade deve ser maior que zero");
            } else {
                this.quantidade = quantidade;
            }
        } catch( Exception e){
            throw new IllegalArgumentException("Quantidade deve ser numerica");
        }

    }

    public void setCategoria(String categoria) {
        if(categoria == null){
            throw new IllegalArgumentException("campo obrigatório");
        } else{
            this.categoria = categoria;
        }

    }
    public Doacao(String descricao, String nome, boolean estatus, int quantidade, String categoria) {
        this.descricao = descricao;
        this.nome = nome;
        this.estatus = estatus;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

}
