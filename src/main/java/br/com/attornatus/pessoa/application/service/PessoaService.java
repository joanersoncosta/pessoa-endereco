package br.com.attornatus.pessoa.application.service;

import br.com.attornatus.pessoa.application.api.PessoaRequest;

import java.util.List;

import br.com.attornatus.pessoa.application.api.PessoaIdResponse;
import br.com.attornatus.pessoa.application.api.PessoaListResponse;

public interface PessoaService {

	public PessoaIdResponse criaPessoa(PessoaRequest pessoaRequest);
	public List<PessoaListResponse> buscaTodasPessoas();
}
