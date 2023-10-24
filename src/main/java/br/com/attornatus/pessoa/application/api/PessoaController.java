package br.com.attornatus.pessoa.application.api;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.pessoa.application.service.PessoaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PessoaController implements PessoaAPI {

	private final PessoaService pessoaService;
	
	@Override
	public PessoaIdResponse postPessoa(@Valid PessoaRequest pessoaRequest) {
		log.info("[inicia] PessoaController - postPessoa");
		PessoaIdResponse pessoaCriada = pessoaService.criaPessoa(pessoaRequest);
		log.info("[finaliza] PessoaController - postPessoa");
		return pessoaCriada;
	}

	@Override
	public List<PessoaListResponse> getTodasPessoas() {
		log.info("[inicia] PessoaController - getTodasPessoas");
		List<PessoaListResponse> pessoas = pessoaService.buscaTodasPessoas();
		log.info("[finaliza] PessoaController - getTodasPessoas");
		return pessoas;
	}
}
