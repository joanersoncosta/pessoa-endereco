package br.com.attornatus.pessoa.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.attornatus.pessoa.domain.Pessoa;

public interface PessoaRepository {
	Pessoa salva(Pessoa pessoa);
	List<Pessoa> buscaTodasPessoas();
	Pessoa buscaPessoaPorId(UUID idPessoa);
	void deletaPessoa(Pessoa pessoa);
}
