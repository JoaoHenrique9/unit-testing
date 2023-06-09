package br.ce.wcaquino.servicos;

import br.ce.wcaquino.exceptions.NaoPodeDividirPorZeroException;

public class Calculadora {

    public int somar(int a, int b) {
        return a + b;
    }

    public int subitrair(int a, int b) {
        return a - b;
    }

    public int divide(int a, int b) throws NaoPodeDividirPorZeroException {
        if (b == 0) {
            throw new NaoPodeDividirPorZeroException();
        }
        return a / b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public int divide(String a, String b) {
        return Integer.valueOf(a) / Integer.valueOf(b);
    }

}
