package br.edu.exemplo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProdutoLimitesTest {

    @Test
    void deveExporNomeDoProduto() {
        Produto produto = new Produto("Teclado");

        assertEquals("Teclado", produto.getNome());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -10})
    void deveIgnorarEntradaInvalidaComEstoqueExistente(int quantidade) {
        Produto produto = new Produto("Teclado");
        produto.adicionarEstoque(5);

        produto.adicionarEstoque(quantidade);

        assertEquals(5, produto.getQuantidade());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -10})
    void deveIgnorarRetiradaInvalida(int quantidade) {
        Produto produto = new Produto("Teclado");
        produto.adicionarEstoque(5);

        produto.retirarEstoque(quantidade);

        assertEquals(5, produto.getQuantidade());
    }

    @Test
    void devePermitirRetiradaDeTodoOEstoque() {
        Produto produto = new Produto("Teclado");
        produto.adicionarEstoque(5);

        produto.retirarEstoque(5);

        assertEquals(0, produto.getQuantidade());
    }

    @Test
    void deveManterEstoqueQuandoEntradaUltrapassarLimiteDeInteiro() {
        Produto produto = new Produto("Teclado");
        produto.adicionarEstoque(Integer.MAX_VALUE);

        produto.adicionarEstoque(1);

        assertEquals(Integer.MAX_VALUE, produto.getQuantidade());
    }
}
