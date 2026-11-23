package br.edu.exemplo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private static final BigDecimal LIMITE_DESCONTO = BigDecimal.valueOf(500);
    private static final BigDecimal FATOR_COM_DESCONTO = new BigDecimal("0.90");

    private final List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public double calcularTotal() {
        BigDecimal subtotal = produtos.stream()
                .map(produto -> BigDecimal.valueOf(produto.getPreco()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (subtotal.compareTo(LIMITE_DESCONTO) >= 0) {
            subtotal = subtotal.multiply(FATOR_COM_DESCONTO);
        }

        return subtotal.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
