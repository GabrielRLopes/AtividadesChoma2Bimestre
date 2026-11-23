package br.edu.exemplo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProdutoTest {

    @ParameterizedTest
    @ValueSource(doubles = {-100.0, Double.NaN, Double.POSITIVE_INFINITY})
    void deveRejeitarPrecoInvalido(double preco) {
        assertThrows(IllegalArgumentException.class, () -> new Produto("Teclado", preco));
    }

    @Test
    void deveExporNomeEPermitirPrecoZero() {
        Produto brinde = new Produto("Brinde", 0.0);

        assertEquals("Brinde", brinde.getNome());
        assertEquals(0.0, brinde.getPreco());
    }
}
