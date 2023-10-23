package br.com.attornatus.pessoa.application.api;

import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.pessoa.application.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PessoaController implements PessoaAPI {

	private PessoaService pessoaService;
	
	@Override
	public PessoaResponse postPessoa(PessoaRequest pessoaRequest) {
		log.info("[inicia] PessoaController - postPessoa");
		PessoaResponse pessoaCriada = pessoaService.criaPessoa(pessoaRequest);
		log.info("[finaliza] PessoaController - postPessoa");
		return pessoaCriada;
	}

}
