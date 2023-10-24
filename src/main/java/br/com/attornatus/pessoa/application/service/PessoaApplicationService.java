package br.com.attornatus.pessoa.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.attornatus.pessoa.application.api.PessoaDetalhadoResponse;
import br.com.attornatus.pessoa.application.api.PessoaIdResponse;
import br.com.attornatus.pessoa.application.api.PessoaListResponse;
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

	@Override
	public List<PessoaListResponse> buscaTodasPessoas() {
		log.info("[inicia] ClienteApplicationService - buscaTodasPessoas");
		List<Pessoa> pessoas = pessoaRepository.buscaTodasPessoas();
		log.info("[finaliza] ClienteApplicationService - buscaTodasPessoas");
		return PessoaListResponse.converteListaPessoas(pessoas);
	}

	@Override
	public PessoaDetalhadoResponse buscaPessoaPorId(UUID idPessoa) {
		log.info("[inicia] ClienteApplicationService - buscaPessoaPorId");
		Pessoa pessoa = pessoaRepository.buscaPessoaPorId(idPessoa);
		log.info("[finaliza] ClienteApplicationService - buscaPessoaPorId");
		return new PessoaDetalhadoResponse(pessoa);
	}

	@Override
	public void deletaPessoaPorId(UUID idPessoa) {
		log.info("[inicia] ClienteApplicationService - deletaPessoaPorId");
		Pessoa pessoa = pessoaRepository.buscaPessoaPorId(idPessoa);
		pessoaRepository.deletaPessoa(pessoa);
		log.info("[finaliza] ClienteApplicationService - deletaPessoaPorId");
	}
}
