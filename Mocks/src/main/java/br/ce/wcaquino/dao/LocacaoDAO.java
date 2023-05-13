package br.ce.wcaquino.dao;

import java.util.List;

import br.ce.wcaquino.entidades.Locacao;

public interface LocacaoDAO {

    void salvar(Locacao locacao);

	List<Locacao> obterLocacoesPendentes();
}
