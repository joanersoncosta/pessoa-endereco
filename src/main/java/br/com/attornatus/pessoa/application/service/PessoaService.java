package br.com.attornatus.pessoa.application.service;

import br.com.attornatus.pessoa.application.api.PessoaRequest;
import br.com.attornatus.pessoa.application.api.PessoaIdResponse;

public interface PessoaService {

	public PessoaIdResponse criaPessoa(PessoaRequest pessoaRequest);
}
