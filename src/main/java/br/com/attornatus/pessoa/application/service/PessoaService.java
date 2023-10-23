package br.com.attornatus.pessoa.application.service;

import br.com.attornatus.pessoa.application.api.PessoaRequest;
import br.com.attornatus.pessoa.application.api.PessoaResponse;

public interface PessoaService {

	public PessoaResponse criaPessoa(PessoaRequest pessoaRequest);
}
