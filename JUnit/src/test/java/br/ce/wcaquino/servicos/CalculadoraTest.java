package br.ce.wcaquino.servicos;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.exceptions.NaoPodeDividirPorZeroException;

public class CalculadoraTest {
    Calculadora calc;

    @Before
    public void setup() {
        calc = new Calculadora();
    }

    @Test
    public void deveSomarDoisValostes() {
        // Cenario
        int a = 5;
        int b = 3;

        // Acao
        int resultado = calc.somar(a, b);

        // Verificacao
        assertEquals(8, resultado);
    }

    @Test
    public void deveSubtrairDoisValores() {
        // Cenario
        int a = 8;
        int b = 5;

        // Acao
        int resultado = calc.subitrair(a, b);

        // Verificacao
        assertEquals(3, resultado);

    }

    @Test
    public void deveDividirDoisValores() throws NaoPodeDividirPorZeroException {
        // Cenario
        int a = 6;
        int b = 3;

        // Acao
        int resultado = calc.divide(a, b);

        // Verificacao
        assertEquals(2, resultado);
    }

    @Test(expected = NaoPodeDividirPorZeroException.class)
    public void deveLancarExcecaoAoDividirPorZero() throws NaoPodeDividirPorZeroException {
        // Cenario
        int a = 10;
        int b = 0;

        // Acao
        int resultado = calc.divide(a, b);

        // Verificacao
        assertEquals(2, resultado);
    }

    @Test
    public void deveMultiplicarDoisValores() {
        // Cenario
        int a = 5;
        int b = 5;

        // Acao
        int resultado = calc.multiplicar(a, b);

        // Verificacao
        assertEquals(25, resultado);
    }
}
