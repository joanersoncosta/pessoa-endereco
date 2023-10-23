package br.com.attornatus.pessoa.application.api;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class PessoaController implements PessoaAPI {

	@Override
	public PessoaResponse postPessoa(PessoaRequest pessoaRequest) {
		log.info("[inicia] PessoaController - postPessoa");
		
		log.info("[finaliza] PessoaController - postPessoa");
		return null;
	}

}
