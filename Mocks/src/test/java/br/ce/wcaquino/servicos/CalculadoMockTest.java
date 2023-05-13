package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class CalculadoMockTest {

    @Mock
    private Calculadora calcMock;

    @Spy
    private Calculadora calcSpy;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void devoMostrarAdiferencaEntreMockSpy() {
        Mockito.when(calcMock.somar(1, 2)).thenReturn(5);
        // Mockito.when(calcSpy.somar(1, 2)).thenReturn(5);
        Mockito.doReturn(5).when(calcSpy).somar(1, 2);
        Mockito.doNothing().when(calcSpy).imprime();

        System.out.println("Mock:" + calcMock.somar(1, 2));
        System.out.println("SPY:" + calcSpy.somar(1, 2));

        System.out.println("Mock:");
        calcMock.imprime();
        System.out.println("SPY");
        calcSpy.imprime();
    }

    @Test
    public void teste() {
        Calculadora calc = Mockito.mock(Calculadora.class);

        ArgumentCaptor<Integer> arCapt = ArgumentCaptor.forClass(Integer.class);
        Mockito.when(calc.somar(arCapt.capture(), arCapt.capture())).thenReturn(5);

        Assert.assertEquals(5, calc.somar(1, 10));
    }

}
