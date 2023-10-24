package br.com.attornatus.pessoa.application.service;

import java.util.List;
import java.util.UUID;

import br.com.attornatus.pessoa.application.api.PessoaAlteracaoRequest;
import br.com.attornatus.pessoa.application.api.PessoaDetalhadoResponse;
import br.com.attornatus.pessoa.application.api.PessoaIdResponse;
import br.com.attornatus.pessoa.application.api.PessoaListResponse;
import br.com.attornatus.pessoa.application.api.PessoaRequest;

public interface PessoaService {

	PessoaIdResponse criaPessoa(PessoaRequest pessoaRequest);
	List<PessoaListResponse> buscaTodasPessoas();
	PessoaDetalhadoResponse buscaPessoaPorId(UUID idPessoa);
	void deletaPessoaPorId(UUID idPessoa);
	void patchAlteraPessoa(UUID idPessoa, PessoaAlteracaoRequest pessoaAlteracaoRequest);
}
