package br.com.attornatus.pessoa.application.service;

import org.springframework.stereotype.Service;

import br.com.attornatus.pessoa.application.api.PessoaRequest;
import br.com.attornatus.pessoa.application.api.PessoaResponse;
import br.com.attornatus.pessoa.domain.Pessoa;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PessoaApplicationService implements PessoaService {

	@Override
	public PessoaResponse criaPessoa(PessoaRequest pessoaRequest) {
		log.info("[inicia] ClienteApplicationService - criaCliente");
		Pessoa pessoa = pessoaRepository.salva(new Pessoa(pessoaRequest));
		log.info("[finaliza] ClienteApplicationService - criaCliente");
		return null;
	}

}
