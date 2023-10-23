package br.com.attornatus.pessoa.application.service;

import org.springframework.stereotype.Service;

import br.com.attornatus.pessoa.application.api.PessoaIdResponse;
import br.com.attornatus.pessoa.application.api.PessoaRequest;
import br.com.attornatus.pessoa.application.repository.PessoaRepository;
import br.com.attornatus.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class PessoaApplicationService implements PessoaService {

	private final PessoaRepository pessoaRepository;
	
	@Override
	public PessoaIdResponse criaPessoa(PessoaRequest pessoaRequest) {
		log.info("[inicia] ClienteApplicationService - criaCliente");
		Pessoa pessoa = pessoaRepository.salva(new Pessoa(pessoaRequest));
		log.info("[finaliza] ClienteApplicationService - criaCliente");
		return PessoaIdResponse.builder()
				.idPessoa(pessoa.getIdPessoa())
				.build();
	}
}
