package br.edu.exemplo;

import java.math.BigDecimal;

public class ContaBancaria {

    private BigDecimal saldo = BigDecimal.ZERO;

    public double getSaldo() {
        return saldo.doubleValue();
    }

    public void depositar(double valor) {
        if (valorValido(valor)) {
            saldo = saldo.add(BigDecimal.valueOf(valor));
        }
    }

    public void sacar(double valor) {
        if (!valorValido(valor)) {
            return;
        }

        BigDecimal valorDoSaque = BigDecimal.valueOf(valor);
        if (valorDoSaque.compareTo(saldo) <= 0) {
            saldo = saldo.subtract(valorDoSaque);
        }
    }

    private static boolean valorValido(double valor) {
        return Double.isFinite(valor) && valor > 0;
    }
}
