package com.example.Aulalab.Model;

public record doacaoDTO (
        long id,
        String descricao,
        String nome,
        boolean estatus,
        int quantidade,
        String categoria) {
}
