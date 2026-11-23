package br.edu.exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BubbleSortLimitesTest {

    @Test
    void deveAceitarVetorVazio() {
        BubbleSort bubbleSort = new BubbleSort(new int[]{});

        bubbleSort.ordenar();

        assertArrayEquals(new int[]{}, bubbleSort.getNumeros());
    }

    @Test
    void deveManterVetorDeUmElemento() {
        BubbleSort bubbleSort = new BubbleSort(new int[]{-7});

        bubbleSort.ordenar();

        assertArrayEquals(new int[]{-7}, bubbleSort.getNumeros());
    }

    @Test
    void deveOrdenarVetorInvertidoComValoresExtremos() {
        BubbleSort bubbleSort = new BubbleSort(new int[]{Integer.MAX_VALUE, 0, -7, Integer.MIN_VALUE});

        bubbleSort.ordenar();

        assertArrayEquals(new int[]{Integer.MIN_VALUE, -7, 0, Integer.MAX_VALUE}, bubbleSort.getNumeros());
    }
}
