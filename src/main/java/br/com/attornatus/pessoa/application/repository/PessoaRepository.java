package br.com.attornatus.pessoa.application.repository;

import java.util.List;

import br.com.attornatus.pessoa.domain.Pessoa;

public interface PessoaRepository {
	Pessoa salva(Pessoa pessoa);
	List<Pessoa> buscaTodasPessoas();
}
