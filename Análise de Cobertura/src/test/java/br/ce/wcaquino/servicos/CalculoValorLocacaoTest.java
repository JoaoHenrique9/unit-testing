package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.builders.FilmeBuilder.umFilme;
import static br.ce.wcaquino.builders.UsuarioBuilder.umUsuario;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import buildermaster.BuilderMaster;

@RunWith(Parameterized.class)
public class CalculoValorLocacaoTest {

    private LocacaoService service;

    @Parameter
    public List<Filme> filmes;

    @Parameter(value = 1)
    public Double valorLocacao;

    @Parameter(value = 2)
    public String cenario;

    private static Filme filme1 = umFilme().agora();
    private static Filme filme2 = umFilme().agora();
    private static Filme filme3 = umFilme().agora();
    private static Filme filme4 = umFilme().agora();
    private static Filme filme5 = umFilme().agora();
    private static Filme filme6 = umFilme().agora();
    private static Filme filme7 = umFilme().agora();

    @Before
    public void setup() {
        service = new LocacaoService();
    }

    @Parameters(name = "{2}")
    public static Collection<Object[]> getParametros() {
        return Arrays.asList(new Object[][] {
                { Arrays.asList(filme1, filme2), 8.0, "2 Filmes Sem Desconto" },
                { Arrays.asList(filme1, filme2, filme3), 11.0, "3 Filmes 25%" },
                { Arrays.asList(filme1, filme2, filme3, filme4), 13.0, "4 Filmes 50%" },
                { Arrays.asList(filme1, filme2, filme3, filme4, filme5), 14.0, "5 Filmes 75%" },
                { Arrays.asList(filme1, filme2, filme3, filme4, filme5, filme6), 14.0, "6 Filmes 100%" },
                { Arrays.asList(filme1, filme2, filme3, filme4, filme5, filme6, filme7), 18.0, "7 Filmes Sem Desconto" }
        });

    }

    @Test
    public void deveCalcularValorLocacaoConsiderandoDescontos() throws FilmeSemEstoqueException, LocadoraException {
        // Cenario
        Usuario usuario = umUsuario().agora();
        // Acao
        Locacao resultado = service.alugarFilme(usuario, filmes);

        // Verificacao
        // 4+4+3+2+1
        assertThat(resultado.getValor(), is(valorLocacao));
    }

    public static void main(String[] args) {
        new BuilderMaster().gerarCodigoClasse(Locacao.class);
    }
}
