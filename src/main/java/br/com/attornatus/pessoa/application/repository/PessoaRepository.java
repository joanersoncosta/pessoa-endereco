package br.com.attornatus.pessoa.application.repository;

import br.com.attornatus.pessoa.domain.Pessoa;

public interface PessoaRepository {
	Pessoa salva(Pessoa pessoa);
}
