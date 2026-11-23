package br.edu.exemplo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContaBancariaLimitesTest {

    @Test
    void deveIniciarComSaldoZero() {
        ContaBancaria conta = new ContaBancaria();

        assertEquals(0.0, conta.getSaldo());
    }

    @Test
    void devePermitirSaqueDoSaldoIntegral() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100.0);

        conta.sacar(100.0);

        assertEquals(0.0, conta.getSaldo());
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -10.0, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
    void deveIgnorarDepositoInvalido(double valor) {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100.0);

        conta.depositar(valor);

        assertEquals(100.0, conta.getSaldo());
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -10.0, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
    void deveIgnorarSaqueInvalido(double valor) {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100.0);

        conta.sacar(valor);

        assertEquals(100.0, conta.getSaldo());
    }

    @Test
    void devePermitirSaquesDecimaisQueSomamOSaldo() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(0.30);

        conta.sacar(0.10);
        conta.sacar(0.20);

        assertEquals(0.0, conta.getSaldo());
    }
}
