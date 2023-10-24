package br.com.attornatus.pessoa.application.service;

import br.com.attornatus.pessoa.application.api.PessoaRequest;

import java.util.List;
import java.util.UUID;

import br.com.attornatus.pessoa.application.api.PessoaDetalhadoResponse;
import br.com.attornatus.pessoa.application.api.PessoaIdResponse;
import br.com.attornatus.pessoa.application.api.PessoaListResponse;

public interface PessoaService {

	PessoaIdResponse criaPessoa(PessoaRequest pessoaRequest);
	List<PessoaListResponse> buscaTodasPessoas();
	PessoaDetalhadoResponse buscaPessoaPorId(UUID idPessoa);
}
