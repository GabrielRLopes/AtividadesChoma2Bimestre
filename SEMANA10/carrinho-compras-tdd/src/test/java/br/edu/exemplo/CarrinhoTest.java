package br.edu.exemplo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarrinhoTest {

    @Test
    void deveTerTotalZeroQuandoVazio() {
        Carrinho carrinho = new Carrinho();

        assertEquals(0.0, carrinho.calcularTotal());
    }

    @Test
    void deveAdicionarUmProduto() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionarProduto(new Produto("Teclado", 100.0));

        assertEquals(100.0, carrinho.calcularTotal());
    }

    @Test
    void deveSomarOsPrecosDeVariosProdutos() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionarProduto(new Produto("Teclado", 100.0));
        carrinho.adicionarProduto(new Produto("Mouse", 50.0));

        assertEquals(150.0, carrinho.calcularTotal());
    }

    @Test
    void deveRetirarApenasOProdutoRemovidoDoTotal() {
        Carrinho carrinho = new Carrinho();
        Produto teclado = new Produto("Teclado", 100.0);
        Produto mouse = new Produto("Mouse", 50.0);
        carrinho.adicionarProduto(teclado);
        carrinho.adicionarProduto(mouse);

        carrinho.removerProduto(mouse);

        assertEquals(100.0, carrinho.calcularTotal());
    }

    @ParameterizedTest
    @CsvSource({"499.99, 499.99", "500.00, 450.00", "500.01, 450.01", "600.00, 540.00"})
    void deveAplicarDescontoAPartirDeQuinhentos(double subtotal, double totalEsperado) {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(new Produto("Monitor", subtotal));

        assertEquals(totalEsperado, carrinho.calcularTotal());
    }

    @Test
    void deveConsiderarOTotalDosProdutosParaAplicarDesconto() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(new Produto("Monitor", 450.0));
        carrinho.adicionarProduto(new Produto("Mouse", 50.0));

        assertEquals(450.0, carrinho.calcularTotal());
    }

    @Test
    void deveRecalcularDescontoAposRemoverProduto() {
        Carrinho carrinho = new Carrinho();
        Produto mouse = new Produto("Mouse", 60.0);
        carrinho.adicionarProduto(new Produto("Monitor", 450.0));
        carrinho.adicionarProduto(mouse);
        assertEquals(459.0, carrinho.calcularTotal());

        carrinho.removerProduto(mouse);

        assertEquals(450.0, carrinho.calcularTotal());
    }
}
