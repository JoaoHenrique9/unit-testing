package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class CalculadoMockTest {

    @Test
    public void teste() {
        Calculadora calc = Mockito.mock(Calculadora.class);

        ArgumentCaptor<Integer> arCapt = ArgumentCaptor.forClass(Integer.class);
        Mockito.when(calc.somar(arCapt.capture(), arCapt.capture())).thenReturn(5);

        Assert.assertEquals(5, calc.somar(1, 10));
    }

}
