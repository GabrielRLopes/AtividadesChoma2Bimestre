package br.edu.exemplo;

public class Produto {

    private final String nome;
    private final double preco;

    public Produto(String nome, double preco) {
        if (!Double.isFinite(preco) || preco < 0) {
            throw new IllegalArgumentException("O preço deve ser finito e não negativo.");
        }
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
